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

Whitespace = [\s]
Newline = (\r|\n|\r\n) 
Space = ({Whitespace}|{Newline})
IntLiteral = 0|[1-9][0-9]* 

/* Strings and Characters */ 
String = [[a-z|A-Z]+['-]*]+
Character = [^[a-z|A-Z|'-]]

%%

<YYINITIAL> {

  /* Super Hipster Keywords */ 
  "AF"						{ return symbol(TokenType.SUPERHIPSTER); }
  "Bae"						{ return symbol(TokenType.SUPERHIPSTER); }
  "Basic"					{ return symbol(TokenType.SUPERHIPSTER); }
  "Break the Internet"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Clap back"				{ return symbol(TokenType.SUPERHIPSTER); }
  "Juice cleanse"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Fruitarian"				{ return symbol(TokenType.SUPERHIPSTER); }
  "Girl Squad"				{ return symbol(TokenType.SUPERHIPSTER); }
  "Keto"					{ return symbol(TokenType.SUPERHIPSTER); }
  "Lit"						{ return symbol(TokenType.SUPERHIPSTER); }
  "Hunty"					{ return symbol(TokenType.SUPERHIPSTER); }
  "Meditation retreat"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Namaste"					{ return symbol(TokenType.SUPERHIPSTER); }
  "On fleek"				{ return symbol(TokenType.SUPERHIPSTER); }
  "Squad"					{ return symbol(TokenType.SUPERHIPSTER); }
  "Spill the tea"			{ return symbol(TokenType.SUPERHIPSTER); }
  "I got some tea"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Spilling the tea"		{ return symbol(TokenType.SUPERHIPSTER); }
  "Sipping the tea"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Sorry not sorry"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Salty"					{ return symbol(TokenType.SUPERHIPSTER); }
  "Swerve"					{ return symbol(TokenType.SUPERHIPSTER); }
  "Turnt Up"				{ return symbol(TokenType.SUPERHIPSTER); }
  "Thirsty"					{ return symbol(TokenType.SUPERHIPSTER); } 
  "Yogi"					{ return symbol(TokenType.SUPERHIPSTER); }
  "Yoga retreat"			{ return symbol(TokenType.SUPERHIPSTER); }
  "Woke"					{ return symbol(TokenType.SUPERHIPSTER); }
  "#"						{ return symbol(TokenType.SUPERHIPSTER);  }



 /* Mildly Hipster Keywords */
  "Adulting"				{ return symbol(TokenType.MILDLYHIPSTER); }
  "Kombucha"				{ return symbol(TokenType.MILDLYHIPSTER); }
  "Humble brag"				{ return symbol(TokenType.MILDLYHIPSTER); }
  "Bye Felicia"				{ return symbol(TokenType.MILDLYHIPSTER); }
  "Brunch"					{ return symbol(TokenType.MILDLYHIPSTER); }
  "Netflix and chill"		{ return symbol(TokenType.MILDLYHIPSTER); }
  "'Merica"					{ return symbol(TokenType.MILDLYHIPSTER); }
  "The struggle is real"	{ return symbol(TokenType.MILDLYHIPSTER); }
  "Pics or it didn't happen" { return symbol(TokenType.MILDLYHIPSTER); }
  "Said no one ever"		{ return symbol(TokenType.MILDLYHIPSTER); }

 /* Semi Hipster Keywords */
  "Goals"					{ return symbol(TokenType.SEMIHIPSTER); }
  "Hulu and chill"			{ return symbol(TokenType.SEMIHIPSTER); }
  "RT"						{ return symbol(TokenType.SEMIHIPSTER); }
  
  /* separators */
  "("							{ /* ignore */  }
  ")"							{ /* ignore */  }
  "{"							{ /* ignore */  }
  "}"							{ /* ignore */  }
  "["                           { /* ignore */  }
  "]"                           { /* ignore */  }
  ";"                           { /* ignore */  }
  "," 							{ /* ignore */  }
  "."							{ /* ignore */  }
  
  /* operators */
  "="                          	{ /* ignore */  }
  ">"                        	{ /* ignore */  }
  "<"                           { /* ignore */  }
  "!"                           { /* ignore */  }
  "~"                           { /* ignore */  }
  "?"                           { /* ignore */  }
  ":"                           { /* ignore */  }
  "&"                           { /* ignore */  }
  "|"                           { /* ignore */  }
  "+"                           { /* ignore */  }
  "-"                           { /* ignore */  }
  "+"                           { /* ignore */  }
  "*"                           { /* ignore */  }
  "/"                           { /* ignore */  }
  "^"                           { /* ignore */  }
  "%"                           { /* ignore */  }
  "'"                           { /* ignore */  }
  "$"                           { /* ignore */  }
  "@"                           { /* ignore */  }
  "~"                           { /* ignore */  }
  "`"                           { /* ignore */  }
  '\'                           { /* ignore */  }
  "?"                           { /* ignore */  }
  "»"							{ /* ignore */  } 
  "_"							{ /* ignore */  } 
  "-"							{ /* ignore */  } 


{Whitespace} 					{ /* ignore */ }

{Newline}						{ /* ignore */ }

{Space} 						{ /* ignore */ }

{IntLiteral}   					{ /* ignore */ } 

{String}						{ yybegin(YYINITIAL); return symbol(TokenType.NOTHIPSTER, string.toString()); }

{Character}						{ yybegin(YYINITIAL); return symbol(TokenType.SYMBOL, yytext().charAt(0)); }
   
}


 [^] {
    System.out.println("wtf: " + yytext());
    return symbol(ExampleSymbols.UNEXPECTED_TOKEN, yytext());
}
  
  
  