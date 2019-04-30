package com.ab.hipsterdex;

/**
 * Token Class - stores the token type, lexeme (character string), 
 * and the location of the token (row and column).
 * @author annabaker
 *
 */

public class Token implements Cloneable {
	private TokenType type;
	private int row;
	private int column;
	private String lexeme;
	
	
	 /**
     * Create a basic token with no explicit lexeme.
     * @param theKind the kind of token
     * @param line line number where token was found
     * @param column column number where token begins
     */
    public Token (final TokenType tokenType, final int r, final int c) {
        type = tokenType;
        lexeme = "";
        row = r;
        column = c;
    }
	
	/**
	 * Constructor that accepts an existing lexeme
	 * @param tokenType - the token type
	 * @param lex - the lexeme
	 */
	
	public Token(final TokenType tokenType, final int r, final int c, String lex) {
		type = tokenType;
		row = r;
		column = c;
		lexeme = lex;
	}
	
	/**
	 * Copy constructor
	 * @param t - token to be copied
	 */
	
	public Token(Token t) {
		this.type = t.type;
		this.lexeme = new String(t.lexeme);
	}
	
	/**
	 * Get token type
	 * @return type
	 */
	public TokenType getType() {
		return type;
	}
	
	/**
	 * Get lexeme
	 * @return lexeme
	 */
	public String getLexeme() {
		return lexeme;
	}
	
	/**
	 * Get row
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Get column
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}
	
	
	/**
	 * Overrides default clone
	 */
	@Override
	public Object clone() {
		return new Token(this);
	}
	
	/**
	 * Overrides default equals
	 * @return boolean, true if this + obj are equal
	 */
	@Override 
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		
		if (obj instanceof Token) {
			if (this == obj) {
				return true;
			}
		}
		
		Token other = (Token)obj;
		
		return this.type.equals(other.type) &&
				this.lexeme.equals(other.lexeme);
	}
	
	@Override
	public int hashCode() {
		int hash = 13;
		hash = 15 * type.hashCode() + lexeme.hashCode();
		return hash;
	}
	
	@Override
	public String toString() {
		 if (getLexeme().length() > 0) {
	            return getType().toString() + ":" + getLexeme();
	        } else {
	            return getType().toString();
	        }
	}
	
}
