package com.ab.hipsterdex;

import java.util.*; 
import java.io.*;  

public class TokenStream {
	
	private ArrayList<Token> tokenStream;
	
	public TokenStream(final Reader input) {
		tokenStream = new ArrayList<Token>();
		
		Lexer lexer = new Lexer(input);
		
		try {
			Token t = lexer.yylex();
			while (t != null) { 
				tokenStream.add(t);
				t = lexer.yylex();
				 
			}
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * Will return token stream as a string
	 * @return String of tokens
	 */
	
	public StringBuilder getTokenStream() {
		StringBuilder s = new StringBuilder();
		
		for (Token t: tokenStream) {
			s.append(t.getType().toString());
		}
		
		return s;
	}
	
	/**
	 * Will return number of tokens
	 * @return number of tokens
	 */
	public int  getNumTokens() {
		return tokenStream.size();
	}
	
	
}
