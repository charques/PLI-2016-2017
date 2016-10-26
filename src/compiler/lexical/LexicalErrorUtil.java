package compiler.lexical;

import es.uned.lsi.compiler.lexical.LexicalError;
import es.uned.lsi.compiler.lexical.LexicalErrorManager;

public class LexicalErrorUtil {

	private static LexicalErrorManager lexicalErrorManager = new LexicalErrorManager();
	
	private static final String errorMsg[] = { 
			"Error: Unmatched end-of-comment punctuation.",
			"Error: Unmatched start-of-comment punctuation.", 
			"Error: Unclosed string.",
			"Error: Malformed identifier.",
			"Error: Illegal character."};

	public static final int E_ENDCOMMENT = 0;
	public static final int E_STARTCOMMENT = 1;
	public static final int E_UNCLOSEDSTR = 2;
	public static final int E_WRONGIDENT = 3;
	public static final int E_UNMATCHED = 4;
	
	public static void error(int code, int line, int column, String lexema) {
		LexicalError error = createLexicalError(code, line, column, lexema);
   		lexicalErrorManager.lexicalError(error);
	}
	
	public static void fatalError(int code, int line, int column, String lexema) {
  		LexicalError error = createLexicalError(code, line, column, lexema);
   		lexicalErrorManager.lexicalFatalError(error);
	}
	
	private static LexicalError createLexicalError(int code, int line, int column, String lexema) {
		LexicalError error = new LexicalError(errorMsg[code]);
   		error.setLine(line);
   		error.setColumn(column);
   		error.setLexema(lexema);
   		return error;
	}

}
