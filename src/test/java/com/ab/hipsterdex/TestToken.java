package com.ab.hipsterdex;
import static org.junit.Assert.*;
import com.ab.hipsterdex.Token;

import org.junit.Test; 

public class TestToken {
	
	Token t1;
	Token t2;
	Token toCopy;
	Token toClone;
	
	public TestToken() {
		t1 = new Token(TokenType.SUPERHIPSTER, 1, 7, "");
		t2 = new Token(TokenType.NOTHIPSTER, 8, 16, "Dry Pasta");
		toCopy = new Token(t1);
		toClone = (Token)t1.clone();
	}
	
	@Test
	public void testTokenConstructor() {
		assertEquals(t1.getType(), TokenType.SUPERHIPSTER);
		assertEquals(t1.getRow(), 1);
		assertEquals(t1.getColumn(), 7);
		assertEquals(t1.getLexeme(), ""); 
		
		assertEquals(t2.getLexeme(), "Dry Pasta");	
	}
	
	@Test
	public void testTokenCopyInstructor() {
		assertEquals(t1, toCopy);
		assertTrue(toCopy.equals(t1));
		assertNotSame(t1, toCopy);
		
		assertEquals(t1.toString(), toCopy.toString());
		assertEquals(t1.hashCode(), toCopy.hashCode());
		assertEquals(t1.getType(), toCopy.getType());
		assertEquals(t1.getRow(), toCopy.getRow());
		assertEquals(t1.getColumn(), toCopy.getColumn()); 
		assertEquals(t1.getLexeme(), toCopy.getLexeme());
	}
	
	@Test
	public void testClone() {
		assertEquals(t1, toClone);
		assertNotSame(t1, toClone);
		
		assertEquals(t1.toString(), toClone.toString());
		assertEquals(t1.hashCode(), toClone.hashCode());
		assertEquals(t1.getType(), toClone.getType());
		assertEquals(t1.getRow(), toClone.getRow());
		assertEquals(t1.getColumn(), toClone.getColumn()); 
		assertEquals(t1.getLexeme(), toClone.getLexeme());
		
	}
	
	@Test
	public void testToString() {
		assertNotSame(t1.toString(), t2.toString());
		assertEquals(t2.toString(), "NOTHIPSTER:Dry Pasta");
	}
	
	@Test
	public void testHashCode() {
		assertNotSame(t1.hashCode(), t2.hashCode());
	}
}
