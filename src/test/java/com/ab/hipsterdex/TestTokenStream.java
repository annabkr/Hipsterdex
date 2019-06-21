package com.ab.hipsterdex;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestTokenStream {
	
	TokenStream ts;
	TokenStream ts2;
	TokenStream tsCopy;
	TokenStream tsClone;
	JavaLexer r;
	Token t1;
	Token t2;
	Token t3;
	Reader read;
	Reader r2; 

	@Before
	public void setup() {  
		t1 = new Token(TokenType.SUPERHIPSTER, 1, 7, "");
		t2 = new Token(TokenType.NOTHIPSTER, 8, 16, "Dry Pasta");
	}
	
	@Test 
	public void testDefaultConstructor(){
		String s = ts.getTokenStream().toString(); 
		assertEquals(ts.getNumTokens(), 5);
	}
	
	@Test 
	public void testCopyConstructor(){
		
		assertEquals(ts, tsCopy);
		assertNotSame(ts, tsCopy);
		assertEquals(ts.getTokenStream().toString(),tsCopy.getTokenStream().toString());
		assertEquals(ts.getNumTokens(), tsCopy.getNumTokens()); 
		assertEquals(ts.hashCode(), tsCopy.hashCode());
		assertEquals(ts.toString(), tsCopy.toString());

	}
	 
	@Test 
	public void testHashCode(){
		
		assertEquals(ts.hashCode(), tsCopy.hashCode());
	}
	
	@Test 
	public void testClone(){
		assertNotSame(ts, tsClone);
		assertEquals(ts, tsClone);
		assertEquals(ts.toString(),tsClone.toString());
		assertEquals(ts.hashCode(), tsClone.hashCode()); 
		assertEquals(ts.getTokenStream().toString(),tsCopy.getTokenStream().toString());
		assertEquals(ts.getNumTokens(), tsCopy.getNumTokens()); 
		assertEquals(ts.hashCode(), tsCopy.hashCode());
		assertEquals(ts.toString(), tsCopy.toString());
	}
	 
	@Test 
	public void testToString(){ 
	}
	
	@Test 
	public void testGetTokenStream(){ 
	}
		
	
}
