/* The following code was generated by JFlex 1.4.1 on 3/11/16 22:02 */

package compiler.lexical;

import compiler.lexical.KeywordMapUtil;
import compiler.lexical.LexicalErrorUtil;
import compiler.syntax.sym;
import compiler.lexical.Token;
import es.uned.lsi.compiler.lexical.ScannerIF;
import es.uned.lsi.compiler.lexical.LexicalError;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 3/11/16 22:02 from the specification file
 * <tt>/Users/cfhernandez/Projects.SRC/PLI-2016-2017/doc/specs/scanner.flex</tt>
 */
public class Scanner implements java_cup.runtime.Scanner, ScannerIF {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 1;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\26\1\0\1\1\1\26\22\0\1\1\1\4\1\11"+
    "\1\0\3\4\1\0\1\6\1\10\1\7\1\20\1\14\1\17\1\25"+
    "\1\21\1\5\11\3\1\16\1\15\1\22\1\24\1\23\1\4\1\0"+
    "\15\2\1\31\3\2\1\32\1\2\1\30\6\2\1\12\1\27\1\13"+
    "\1\0\1\4\1\0\15\2\1\31\3\2\1\32\1\2\1\30\6\2"+
    "\46\0\1\4\35\0\1\4\1\0\1\4\5\0\1\4\1\0\1\4"+
    "\3\0\1\4\5\0\1\4\6\0\1\4\6\0\1\4\5\0\1\4"+
    "\1\0\1\4\3\0\1\4\5\0\1\4\6\0\1\4\uff05\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\5\1\4\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\2\2"+
    "\1\26\1\27\1\30\1\31\2\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44";

  private static int [] zzUnpackAction() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\33\0\66\0\121\0\121\0\154\0\207\0\242"+
    "\0\275\0\330\0\363\0\121\0\121\0\121\0\121\0\121"+
    "\0\121\0\u010e\0\121\0\121\0\121\0\u0129\0\121\0\121"+
    "\0\121\0\u0144\0\u015f\0\u017a\0\121\0\121\0\u0195\0\u01b0"+
    "\0\275\0\121\0\121\0\121\0\121\0\121\0\121\0\121"+
    "\0\121\0\121\0\121";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\5\1\4"+
    "\3\6\6\5\1\32\1\33\23\5\11\34\1\35\14\34"+
    "\1\36\1\37\3\34\35\0\2\6\1\10\1\6\22\0"+
    "\3\6\2\0\1\10\1\7\1\10\1\7\22\0\3\10"+
    "\2\0\4\10\22\0\3\10\2\0\1\10\1\40\1\10"+
    "\1\41\22\0\3\10\7\0\1\42\33\0\1\43\46\0"+
    "\1\44\31\0\1\45\16\0\1\46\33\0\1\47\22\0"+
    "\11\34\1\0\14\34\2\0\3\34\11\0\1\50\16\0"+
    "\1\51\1\52\1\53\2\0\1\10\1\40\2\10\22\0"+
    "\3\10";

  private static int [] zzUnpackTrans() {
    int [] result = new int[459];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\2\11\6\1\6\11\1\1\3\11\1\1\3\11"+
    "\3\1\2\11\3\1\12\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	StringBuffer string = new StringBuffer();
  	private int commentCount = 0;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 158) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) throws LexicalError {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new LexicalError(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  throws LexicalError {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, LexicalError {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 2: 
          { /* ignore */
          }
        case 37: break;
        case 4: 
          { return (new Token(sym.INTEGER_LITERAL, yyline + 1, yycolumn + 1, yytext()));
          }
        case 38: break;
        case 24: 
          { LexicalErrorUtil.error(LexicalErrorUtil.E_UNCLOSEDSTR, yyline + 1, yycolumn + 1, string.toString());
    	yybegin(YYINITIAL);
          }
        case 39: break;
        case 34: 
          { string.append('\t');
          }
        case 40: break;
        case 9: 
          { string.setLength(0);
		yybegin(STRING);
          }
        case 41: break;
        case 31: 
          { commentCount  = commentCount + 1;
          }
        case 42: break;
        case 1: 
          { LexicalErrorUtil.error(LexicalErrorUtil.E_UNMATCHED, yyline + 1, yycolumn + 1, yytext());
          }
        case 43: break;
        case 20: 
          { return (new Token(sym.EQUAL, yyline + 1, yycolumn + 1, yytext()));
          }
        case 44: break;
        case 8: 
          { return (new Token(sym.RIGHT_PARENTHESIS, yyline + 1, yycolumn + 1, yytext()));
          }
        case 45: break;
        case 25: 
          { string.append('\\');
          }
        case 46: break;
        case 36: 
          { string.append('\r');
          }
        case 47: break;
        case 29: 
          { return (new Token(sym.ASSIGNMENT, yyline + 1, yycolumn + 1, yytext()));
          }
        case 48: break;
        case 33: 
          { string.append('\"');
          }
        case 49: break;
        case 21: 
          { return (new Token(sym.DOT, yyline + 1, yycolumn + 1, yytext()));
          }
        case 50: break;
        case 10: 
          { return (new Token(sym.LEFT_BRACKET, yyline + 1, yycolumn + 1, yytext()));
          }
        case 51: break;
        case 17: 
          { return (new Token(sym.DIVIDE, yyline + 1, yycolumn + 1, yytext()));
          }
        case 52: break;
        case 12: 
          { return (new Token(sym.COMMA, yyline + 1, yycolumn + 1, yytext()));
          }
        case 53: break;
        case 23: 
          { yybegin(YYINITIAL);
		int column = yycolumn - string.toString().length();
		return (new Token(sym.STRING, yyline + 1, column, string.toString()));
          }
        case 54: break;
        case 5: 
          { LexicalErrorUtil.error(LexicalErrorUtil.E_WRONGIDENT, yyline + 1, yycolumn + 1, yytext());
          }
        case 55: break;
        case 32: 
          { commentCount  = commentCount - 1;
		if (commentCount == 0) {
			yybegin(YYINITIAL);
		}
          }
        case 56: break;
        case 35: 
          { string.append('\n');
          }
        case 57: break;
        case 26: 
          { LexicalErrorUtil.error(LexicalErrorUtil.E_WRONGINTEG, yyline + 1, yycolumn + 1, yytext());
          }
        case 58: break;
        case 18: 
          { return (new Token(sym.LESS_THAN, yyline + 1, yycolumn + 1, yytext()));
          }
        case 59: break;
        case 19: 
          { return (new Token(sym.MORE_THAN, yyline + 1, yycolumn + 1, yytext()));
          }
        case 60: break;
        case 16: 
          { return (new Token(sym.PLUS, yyline + 1, yycolumn + 1, yytext()));
          }
        case 61: break;
        case 15: 
          { return (new Token(sym.MINUS, yyline + 1, yycolumn + 1, yytext()));
          }
        case 62: break;
        case 3: 
          { Integer keywordId = KeywordMapUtil.getKeywordId(yytext());
		if(keywordId != null) {
			return (new Token(keywordId, yyline + 1, yycolumn + 1, yytext()));
		}
		else {
			return (new Token(sym.IDENTIFIER, yyline + 1, yycolumn + 1, yytext().toLowerCase()));
		}
          }
        case 63: break;
        case 28: 
          { LexicalErrorUtil.error(LexicalErrorUtil.E_ENDCOMMENT, yyline + 1, yycolumn + 1, "");
          }
        case 64: break;
        case 11: 
          { return (new Token(sym.RIGHT_BRACKET, yyline + 1, yycolumn + 1, yytext()));
          }
        case 65: break;
        case 7: 
          { return (new Token(sym.TIMES, yyline + 1, yycolumn + 1, yytext()));
          }
        case 66: break;
        case 27: 
          { yybegin(COMMENT);
		commentCount = commentCount + 1;
          }
        case 67: break;
        case 14: 
          { return (new Token(sym.COLON, yyline + 1, yycolumn + 1, yytext()));
          }
        case 68: break;
        case 13: 
          { return (new Token(sym.SEMICOLON, yyline + 1, yycolumn + 1, yytext()));
          }
        case 69: break;
        case 6: 
          { return (new Token(sym.LEFT_PARENTHESIS, yyline + 1, yycolumn + 1, yytext()));
          }
        case 70: break;
        case 22: 
          { string.append( yytext() );
          }
        case 71: break;
        case 30: 
          { return (new Token(sym.NOT_EQUAL, yyline + 1, yycolumn + 1, yytext()));
          }
        case 72: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {
                if (commentCount > 0) {
		LexicalErrorUtil.error(LexicalErrorUtil.E_STARTCOMMENT, yyline + 1, yycolumn + 1, "");
	}
	return null;
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
