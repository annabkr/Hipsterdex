package com.ab.hipsterdex;

import java.io.*;    
import java.net.MalformedURLException;
import java.net.URL;

import de.l3s.boilerpipe.extractors.ArticleExtractor; 
 

public class Hipsterdex {
	static public void main(String[] args) throws Exception {
		
		//	StringReader t = new StringReader("Trump says 'My sick AF idea':");
			
		//	TokenStream s = new TokenStream(t); 
			
			try {
				URL url = new URL("https://www.instagram.com/janebrink/");
				 
				StringReader text = new StringReader(ArticleExtractor.INSTANCE.getText(url)); 
			 
				TokenStream ts = new TokenStream(text);
				
				System.out.println(ts.getNumTokens()); 
				
				
			} catch (IOException e) {
				System.out.println("I/O Error: " + e.getMessage());
			}
	     
			
		 
					    
			 
		//	String s = "Hello";
		//	Reader reader = new StringReader(s);  
		//	TokenStream t = new TokenStream(reader);
			
		//	int numTokens = t.getNumTokens();
		//	StringBuilder result = t.getTokenStream();
			
		//	System.out.println(result.toString());
		//	System.out.println(numTokens);
			
		}
	
}
