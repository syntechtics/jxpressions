package parser;

import java_cup.runtime.*;

%%

%class Scanner
%unicode
%cup
%line
%column

%{

  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
Identifier     = [A-Za-z_][A-Za-z0-9_]*

DecIntegerLiteral = 0 | [1-9][0-9]* | [0-9]+\.[0-9]+

%state STRING


%%

<YYINITIAL> {
 
  /* literals */
  {DecIntegerLiteral}            { return symbol(sym.NUMBER, Double.valueOf(yytext())); }
  \"                             { string.setLength(0); yybegin(STRING); }

  /* operators */
  "+"                            { return symbol(sym.PLUS); }
  "-"                            { return symbol(sym.MINUS);  }
  "*"                            { return symbol(sym.TIMES);  }
  "/"                            { return symbol(sym.DIVIDE); }
  "%"                            { return symbol(sym.MOD);    }
  "("                            { return symbol(sym.LPAREN); }
  ")"                            { return symbol(sym.RPAREN); }
  ","                            { return symbol(sym.COMMA); }
  "=="                           { return symbol(sym.EQEQ); }
  ">="                           { return symbol(sym.GTEQ); }
  "<="                           { return symbol(sym.LTEQ); }
  ">"                            { return symbol(sym.GT); }
  "<"                            { return symbol(sym.LT); }
  "!="                           { return symbol(sym.NOTEQ); }
  "&&"                           { return symbol(sym.AND); }
  "||"                           { return symbol(sym.OR); }
  "!"                            { return symbol(sym.NOT); }
  
  /* SEMI COLON IS EOF */
  ";"                            { yyclose(); return symbol(sym.SEMI); }
   
  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
  
  {Identifier}                   { return symbol(sym.IDENTIFIER, yytext()); }
}

<STRING> {
  \"                             { yybegin(YYINITIAL); 
                                   return symbol(sym.STRING, 
                                   string.toString()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                    yytext()+">"); }