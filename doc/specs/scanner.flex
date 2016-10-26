package compiler.lexical;

import compiler.lexical.KeywordMapUtil;
import compiler.lexical.LexicalErrorUtil;
import compiler.syntax.sym;
import compiler.lexical.Token;
import es.uned.lsi.compiler.lexical.ScannerIF;
import es.uned.lsi.compiler.lexical.LexicalError;

%%
 
%public
%class Scanner
%char
%line
%column
%cup

%implements ScannerIF
%scanerror LexicalError

%{
  	private int commentCount = 0;
%}  

%state COMMENT

WHITE_SPACE = [ \t\r\n\f]
IDENTIFIER_OR_KEYWORD = [a-zA-Z] [a-zA-Z0-9]*
IDENTIFIER_MALFORMED = [0-9]* [a-zA-Z0-9_.]+
INTEGER_LITERAL = 0 | [1-9][0-9]*
STRING_TEXT = ([^\n\"])*
COMMENT_TEXT = [^*)]+
//( [^*] | \*+ [^(*] )*

%%

<YYINITIAL,COMMENT> \n { }

<YYINITIAL> "(*" { 
	yybegin(COMMENT);
	commentCount  = commentCount + 1;
	System.out.println("1 " + yytext());
}
<YYINITIAL> "*)" {
	LexicalErrorUtil.error(LexicalErrorUtil.E_STARTCOMMENT, yyline + 1, yycolumn + 1, yytext());
}

<COMMENT> "(*" { 
	System.out.println("2 " + yytext());
	commentCount  = commentCount + 1; }
<COMMENT> "*)" {
	commentCount  = commentCount - 1; 
	if (commentCount < 0) {
		System.out.println("4 " + yytext());
		
		// OJO: tiene sentido aqui? ya no por la regla de texto que deja fuera los cierres
		
		LexicalErrorUtil.error(LexicalErrorUtil.E_ENDCOMMENT, yyline + 1, yycolumn + 1, yytext());
	}
	if (commentCount == 0) {
		System.out.println("5 " + yytext());
		yybegin(YYINITIAL);
	}
}
<COMMENT> {COMMENT_TEXT} { 
	System.out.println("6 " + yytext());
	/* ignore */ 
}

<YYINITIAL> 
{
	// Identifier or keyword
	{IDENTIFIER_OR_KEYWORD} {
		Integer keywordId = KeywordMapUtil.getKeywordId(yytext());
		if(keywordId != null) {
			return (new Token(keywordId, yyline + 1, yycolumn + 1, yytext()));
		}
		else {
			return (new Token(sym.IDENTIFIER, yyline + 1, yycolumn + 1, yytext().toLowerCase()));
		} 
	}
	{IDENTIFIER_MALFORMED} { LexicalErrorUtil.error(LexicalErrorUtil.E_WRONGIDENT, yyline + 1, yycolumn + 1, yytext()); }
	
	// Literals
	{INTEGER_LITERAL} 	{ return (new Token(sym.INTEGER_LITERAL, yyline + 1, yycolumn + 1, yytext())); }
	\"{STRING_TEXT}\" 	{ return (new Token(sym.STRING, yyline + 1, yycolumn + 1, yytext())); }
	\"{STRING_TEXT} 	{ LexicalErrorUtil.error(LexicalErrorUtil.E_UNCLOSEDSTR, yyline + 1, yycolumn + 1, yytext()); }
    
    // Delimiters
    "("		{ return (new Token(sym.LEFT_PARENTHESIS, yyline + 1, yycolumn + 1, yytext())); }
	")"		{ return (new Token(sym.RIGHT_PARENTHESIS, yyline + 1, yycolumn + 1, yytext())); }
	"["		{ return (new Token(sym.LEFT_BRACKET, yyline + 1, yycolumn + 1, yytext())); }
	"]"		{ return (new Token(sym.RIGHT_BRACKET, yyline + 1, yycolumn + 1, yytext())); }
	","		{ return (new Token(sym.COMMA, yyline + 1, yycolumn + 1, yytext())); }
	";"		{ return (new Token(sym.SEMICOLON, yyline + 1, yycolumn + 1, yytext())); }
    ":"		{ return (new Token(sym.COLON, yyline + 1, yycolumn + 1, yytext())); }
		
	// Operators
	"-" 	{ return (new Token(sym.MINUS, yyline + 1, yycolumn + 1, yytext())); }
	"+" 	{ return (new Token(sym.PLUS, yyline + 1, yycolumn + 1, yytext())); }
    "*" 	{ return (new Token(sym.PRODUCT, yyline + 1, yycolumn + 1, yytext())); }
    "/" 	{ return (new Token(sym.DIVISION, yyline + 1, yycolumn + 1, yytext())); }
    "<"		{ return (new Token(sym.LESS_THAN, yyline + 1, yycolumn + 1, yytext())); }
	">"		{ return (new Token(sym.MORE_THAN, yyline + 1, yycolumn + 1, yytext())); }
	"="		{ return (new Token(sym.EQUAL, yyline + 1, yycolumn + 1, yytext())); }
	"<>"	{ return (new Token(sym.NOT_EQUAL, yyline + 1, yycolumn + 1, yytext())); }
	":="	{ return (new Token(sym.ASSIGNMENT, yyline + 1, yycolumn + 1, yytext())); }
	"."		{ return (new Token(sym.DOT, yyline + 1, yycolumn + 1, yytext())); }

	// White spaces and carriage returns
   	{WHITE_SPACE}	{ /* ignore */}

    // no match
	[^]	{ LexicalErrorUtil.error(LexicalErrorUtil.E_UNMATCHED, yyline + 1, yycolumn + 1, yytext()); }
}




                         


