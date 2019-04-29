package hipsterdex;

%%

%public
%class Lexer 

%unicode

%line
%column

%type Token


%{
  StringBuilder string = new StringBuilder();
  
  private Token symbol(TokenType type) {
    return new Token(type, yyline+1, yycolumn+1, type.toString());
  }

  private Token symbol(TokenType type, String value) {
    return new Token(type, yyline+1, yycolumn+1, value);
  }
  
  private Token symbol(TokenType type, Object value) {
    return new Token(type, yyline+1, yycolumn+1, value.toString());
  }
  


  
%}

whitespace = [\ \t]
newline = (\r|\n|\r\n) 
space = ({whitespace}|{newline})
IntLiteral = 0 | [1-9][0-9]*

/* string and character literals */ 
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]
SingleString = [a-z]+


%state STRING, CHARLITERAL

%%

<YYINITIAL> {

  /* Super Hipster Keywords */ 
  "AF"				{ return symbol(TokenType.SUPERHIPSTER); }
  "Bae"				{ return symbol(TokenType.SUPERHIPSTER); }
  "Basic"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Break the Internet"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Clap back"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Juice cleanse"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Fruitarian"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Girl Squad"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Keto"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Lit"				{ return symbol(TokenType.SUPERHIPSTER); }
  "Hunty"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Meditation retreat"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Namaste"			{ return symbol(TokenType.SUPERHIPSTER); }
  "On fleek"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Squad"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Spill the tea"		{ return symbol(TokenType.SUPERHIPSTER); }
  "I got some tea"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Spilling the tea"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Sipping the tea"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Sorry not sorry"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Salty"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Swerve"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Turnt Up"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Thirsty"			{ return symbol(TokenType.SUPERHIPSTER); }
  [Y(a)*s|y(a)*s|Y(A)*S]	{ return symbol(TokenType.SUPERHIPSTER); }
  "Yogi"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Yoga retreat"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Woke"			{ return symbol(TokenType.SUPERHIPSTER); }



 /* Mildly Hipster Keywords */
  "Adulting"			{ return symbol(TokenType.MILDLYHIPSTER); }
  "Kombucha"			{ return symbol(TokenType.MILDLYHIPSTER); }
  "Humble brag"			{ return symbol(TokenType.MILDLYHIPSTER); }
  "Bye Felicia"			{ return symbol(TokenType.MILDLYHIPSTER); }
  "Brunch"			{ return symbol(TokenType.MILDLYHIPSTER); }
  "Netflix and chill"		{ return symbol(TokenType.MILDLYHIPSTER); }
  "'Merica"			{ return symbol(TokenType.MILDLYHIPSTER); }
  "The struggle is real"	{ return symbol(TokenType.MILDLYHIPSTER); }
  "Pics or it didn't happen"	{ return symbol(TokenType.MILDLYHIPSTER); }
  "Said no one ever"		{ return symbol(TokenType.MILDLYHIPSTER); }

 /* Semi Hipster Keywords */
  "Goals"			{ return symbol(TokenType.SEMIHIPSTER); }
  "Hulu and chill"		{ return symbol(TokenType.SEMIHIPSTER); }
  "RT"				{ return symbol(TokenType.SEMIHIPSTER); }

 /* string literal */
  \"                             { yybegin(STRING); string.setLength(0); }

  /* character literal */
  \'                             { yybegin(CHARLITERAL); }


{whitespace} 			{ /* ignore */ }

{newline}			{ /* ignore */ }

{space} 			{ /* ignore */ }

{IntLiteral}   			{ /* ignore */ } 
		
{SingleString}		   	{ return symbol(TokenType.NOTHIPSTER); }

  
}


<STRING> {
  \"                             { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, string.toString()); }
  
  {StringCharacter}+            { string.append( yytext() ); } 
  
  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }
  \\[0-3]?[0-7]?[0-7]  { char val = (char) Integer.parseInt(yytext().substring(1),8);
                        				   string.append( val ); }
  
}

<CHARLITERAL> {

{SingleCharacter}\'            { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, yytext().charAt(0)); }
  
  /* escape sequences */
  "\\b"\'                        { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, '\b');}
  "\\t"\'                        { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, '\t');}
  "\\n"\'                        { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, '\n');}
  "\\f"\'                        { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, '\f');}
  "\\r"\'                        { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, '\r');}
  "\\\""\'                       { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, '\"');}
  "\\'"\'                        { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, '\'');}
  "\\\\"\'                       { yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, '\\'); }
  \\[0-3]?[0-7]?[0-7]\' { yybegin(YYINITIAL); 
			                              int val = Integer.parseInt(yytext().substring(1,yylength()-1),8);
			                            return symbol(TokenType.NOTHIPSTER, (char)val); }
 }

  