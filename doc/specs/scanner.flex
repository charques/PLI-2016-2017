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

%unicode
%ignorecase

%implements ScannerIF
%scanerror LexicalError

%{
	StringBuffer string = new StringBuffer();
  	private int commentCount = 0;
%}  

%state COMMENT
%state STRING

WHITE_SPACE = [ \t\r\n\f]
IDENTIFIER_OR_KEYWORD = [a-zA-Z] [a-zA-Z0-9]*
IDENTIFIER_MALFORMED = [0-9]* [a-zA-Z0-9_áéíóúÁÉÍÓÚçÇ$%&¡!¿?]+
INTEGER_LITERAL = 0 | [1-9][0-9]*
INTEGER_MALFORMED = 0+[1-9]*

%%

<YYINITIAL> 
{
	// Comment
	"(*" { 
		yybegin(COMMENT);
		commentCount = commentCount + 1;
	}
	"*)" { LexicalErrorUtil.error(LexicalErrorUtil.E_ENDCOMMENT, yyline + 1, yycolumn + 1, ""); }

	// Literals
	{INTEGER_LITERAL} 	{ return (new Token(sym.INTEGER_LITERAL, yyline + 1, yycolumn + 1, yytext())); }
	{INTEGER_MALFORMED} { LexicalErrorUtil.error(LexicalErrorUtil.E_WRONGINTEG, yyline + 1, yycolumn + 1, yytext()); }
	\" { 
		string.setLength(0);
		yybegin(STRING); 
	}

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
	
    // Delimiters
    "("		{ return (new Token(sym.LEFT_PARENTHESIS, yyline + 1, yycolumn + 1, yytext())); }
	")"		{ return (new Token(sym.RIGHT_PARENTHESIS, yyline + 1, yycolumn + 1, yytext())); }
	"["		{ return (new Token(sym.LEFT_BRACKET, yyline + 1, yycolumn + 1, yytext())); }
	"]"		{ return (new Token(sym.RIGHT_BRACKET, yyline + 1, yycolumn + 1, yytext())); }
	","		{ return (new Token(sym.COMMA, yyline + 1, yycolumn + 1, yytext())); }
	";"		{ return (new Token(sym.SEMICOLON, yyline + 1, yycolumn + 1, yytext())); }
    ":"		{ return (new Token(sym.COLON, yyline + 1, yycolumn + 1, yytext())); }
		
	// Operators
	"+" 	{ return (new Token(sym.PLUS, yyline + 1, yycolumn + 1, yytext())); }
    "/" 	{ return (new Token(sym.DIVIDE, yyline + 1, yycolumn + 1, yytext())); }
    "<"		{ return (new Token(sym.LESS_THAN, yyline + 1, yycolumn + 1, yytext())); }
	"<>"	{ return (new Token(sym.NOT_EQUAL, yyline + 1, yycolumn + 1, yytext())); }
	":="	{ return (new Token(sym.ASSIGNMENT, yyline + 1, yycolumn + 1, yytext())); }
	"."		{ return (new Token(sym.DOT, yyline + 1, yycolumn + 1, yytext())); }

	// White spaces and carriage returns
   	{WHITE_SPACE}	{ /* ignore */}

    // no match
	[^]	{ LexicalErrorUtil.error(LexicalErrorUtil.E_UNMATCHED, yyline + 1, yycolumn + 1, yytext()); }
}
	
<COMMENT> {
	"(*" { commentCount  = commentCount + 1; }
	"*)" {
		commentCount  = commentCount - 1;
		if (commentCount == 0) {
			yybegin(YYINITIAL);
		}
	}
	(.|\n) { /* ignore */ }
}

<STRING> {
	\" { 
		yybegin(YYINITIAL);
		int column = yycolumn - string.toString().length();
		return (new Token(sym.STRING, yyline + 1, column, string.toString())); 
	}
	[^\n\r\"\\]+	{ string.append( yytext() ); }
    \\t				{ string.append('\t'); }
    \\n				{ string.append('\n'); }
	\\r             { string.append('\r'); }
    \\\"            { string.append('\"'); }
    \\              { string.append('\\'); }
    [^]	{
    	LexicalErrorUtil.error(LexicalErrorUtil.E_UNCLOSEDSTR, yyline + 1, yycolumn + 1, string.toString());
    	yybegin(YYINITIAL);
    }
}

<<EOF>> {
	if (commentCount > 0) {
		LexicalErrorUtil.error(LexicalErrorUtil.E_STARTCOMMENT, yyline + 1, yycolumn + 1, "");
	}
	return null;
}
