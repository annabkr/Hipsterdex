package com.ab.hipsterdex;

import java.io.*;    
import java.net.MalformedURLException;
import java.net.URL;

import de.l3s.boilerpipe.extractors.ArticleExtractor; 
 

public class Hipsterdex {
	
	static public void main(String[] args) throws Exception {	
			try {
				URL url = new URL(args[0]);
				 
				StringReader text = new StringReader(ArticleExtractor.INSTANCE.getText(url)); 
			 
				TokenStream ts = new TokenStream(text);
				
				System.out.println(ts.getNumTokens()); 
				
				
			} catch (IOException e) {
				System.out.println("I/O Error: " + e.getMessage());
			} 
			
		}
	
}
