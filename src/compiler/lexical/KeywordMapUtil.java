package compiler.lexical;

import java.util.HashMap;

import compiler.syntax.sym;

public class KeywordMapUtil {

	private static HashMap<String, Integer> keywordMap = null;
	
	public static Integer getKeywordId(String key) {
		if (keywordMap == null) {
			init();
		}
		Integer value = keywordMap.get(key);
		return value;
	}

	private static void init() {
		
		keywordMap = new HashMap<String, Integer>();
		keywordMap.put("AND", sym.AND);
		keywordMap.put("ARRAY", sym.ARRAY);
	  	keywordMap.put("BEGIN", sym.BEGIN);
	  	keywordMap.put("BOOLEAN", sym.BOOLEAN);
	  	keywordMap.put("CONST", sym.CONST);
	  	keywordMap.put("DO", sym.DO);
	  	keywordMap.put("ELSE", sym.ELSE);
	  	keywordMap.put("END", sym.END);
	  	keywordMap.put("FALSE", sym.FALSE);
	  	keywordMap.put("IF", sym.IF);
	  	keywordMap.put("INTEGER", sym.INTEGER);
	  	keywordMap.put("MODULE", sym.MODULE);
	  	keywordMap.put("NOT", sym.NOT);
	  	keywordMap.put("OF", sym.OF);
	  	keywordMap.put("OR", sym.OR);
	  	keywordMap.put("PROCEDURE", sym.PROCEDURE);
	  	keywordMap.put("RECORD", sym.RECORD);
	  	keywordMap.put("RETURN", sym.RETURN);
	  	keywordMap.put("THEN", sym.THEN);
	  	keywordMap.put("TO", sym.TO);
	  	keywordMap.put("TRUE", sym.TRUE);
	  	keywordMap.put("TYPE", sym.TYPE);
	  	keywordMap.put("VAR", sym.VAR);
	  	keywordMap.put("WHILE", sym.WHILE);
	  	keywordMap.put("WRITESTRING", sym.WRITESTRING);
	  	keywordMap.put("WRITEINT", sym.WRITEINT);
	  	keywordMap.put("WRITELN", sym.WRITELN);
	}

}
