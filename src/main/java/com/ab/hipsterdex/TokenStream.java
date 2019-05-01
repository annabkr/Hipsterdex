package com.ab.hipsterdex;

import java.util.*; 
import java.io.*;  

public class TokenStream {
	
	protected ArrayList<Token> tokenStream;
	
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
	 * Copy constructor. Will create a deep copy of the object.
	 * @param ts - tokenStream to be copied
	 */ 
	public TokenStream(TokenStream ts) {
		ArrayList<Token> clone = new ArrayList<>();
		
		Iterator<Token> it = ts.tokenStream.iterator();
		
		while (it.hasNext()) {
			clone.add((Token) it.next().clone()); 
		}	
		
		this.tokenStream = clone;
	}
	
	/**
	 * Will return token stream as a string 
	 * @return String of tokens
	 */
	public StringBuilder getTokenStream() {
		StringBuilder s = new StringBuilder();
	
		for (Token t: tokenStream) {
			s.append(t.getType().toString() + ",");  
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
	
	/**
	 * Overrides the default clone.
	 */
	@Override
	public Object clone() {
		return new TokenStream(this);
	}

	/**
	 * Overrides the default equals method.
	 * @return true if both objects have the same tokenStream.
	 */
	@Override
	public boolean equals (Object obj) {
		//Edge cases
		if (obj == null) { return false; }
		if (!(obj instanceof TokenStream)) { return false; }
		if (this == obj) { return true; }
		
		//The meat of the method
		TokenStream otherObj = (TokenStream) obj;
		return this.tokenStream.equals(otherObj.tokenStream);
	}
	
	/**
	 * Overrides the default hashCode method
	 * @return the hashcode
	 */
	@Override
	public int hashCode() {
		int result = 13;
		
		result = 33 * result + tokenStream.hashCode(); 
		
		return result;
	}
	
	
}
