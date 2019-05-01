package com.ab.hipsterdex;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.StringReader;
import com.ab.hipsterdex.TokenStream;

public class TestTokenStream {
	private StringReader str;
	private TokenStream ts1;
	private TokenStream ts2;
	private TokenStream toCopy;
	private TokenStream toClone;
	
	public TestTokenStream() {
		str = new StringReader("Fruitarians don't eat dogs");
		ts1 = new TokenStream(str);
		ts2 = new TokenStream(new StringReader("I love dogs")); 
		toCopy = new TokenStream(ts1);
		toClone = (TokenStream)ts1.clone();
	}
	
	@Test
	public void testTokenStreamConstructor() { 
		TokenStream ts3 = new TokenStream(new StringReader("Fruitarians don't eat dogs"));

		assertEquals(ts3.getTokenStream().toString(), ts1.getTokenStream().toString());
		assertNotSame(ts3.getTokenStream().toString(), ts2.getTokenStream().toString());
		assertSame(ts3.getNumTokens(), ts1.getNumTokens());
		assertNotSame(ts3.getNumTokens(), ts2.getNumTokens()); 
		
	}
	
	@Test
	public void testTokenStreamCopyConstructor() {
		//Test equality. 
		assertEquals(ts1, toCopy);
		assertNotSame(ts1, toCopy);
		assertTrue(toCopy.equals(ts1));
		assertEquals(ts1.getTokenStream().toString(), toCopy.getTokenStream().toString());
		assertEquals(ts1.getNumTokens(), toCopy.getNumTokens());
		
		//Change something in the copy.
		Token t = new Token(TokenType.SUPERHIPSTER, 1, 2, "Fruitarian");
		toCopy.tokenStream.add(t);
		String newStream = (ts1.getTokenStream().toString()) + "SUPERHIPSTER,";
		
		//Re-test.
		assertNotEquals(ts1, toCopy);
		assertFalse(toCopy.equals(ts1));
		assertNotSame(ts1, toCopy);
		assertNotEquals(ts1.getTokenStream().toString(), toCopy.getTokenStream().toString());
		assertEquals(toCopy.getTokenStream().toString(), newStream);
		assertNotEquals(ts1.getNumTokens(), toCopy.getNumTokens());
	}
	
	@Test
	public void testTokenStreamClone() {
		assertEquals(ts1, toClone);
		assertNotSame(ts1, toClone);
		assertTrue(toClone.equals(ts1));
		assertEquals(ts1.getTokenStream().toString(), toClone.getTokenStream().toString());
		assertEquals(ts1.getNumTokens(), toClone.getNumTokens());
		assertNotEquals(toClone, ts2);
	}
	
	@Test
	public void testTokenStreamToString() {
		StringBuilder sb = new StringBuilder("SUPERHIPSTER,NOTHIPSTER,NOTHIPSTER,NOTHIPSTER,");
//		assertEquals(ts1.tokenStream.toString(), sb);
	}
	
	@Test
	public void testTokenStreamHashCode() {
		assertEquals(ts1.hashCode(), toClone.hashCode());
		assertEquals(ts1.hashCode(), toCopy.hashCode());
	}
	

}
