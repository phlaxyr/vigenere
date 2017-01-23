package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.commons.math3.random.MersenneTwister;
 
public class VigenereHandler {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String keyword;
        String vigenereGen;
        System.out.println("Enter a Vigenere Cipher Key:");
        vigenereGen = br.readLine(); 
        MersenneTwister mt = new MersenneTwister(AlphaNumericToNumeric.convert(vigenereGen));
        char[][] vigenereKey=new char[26][26];
        //first is keyword
        //second is message
        // TODO vigenere generation
        char[] chrsmaster = {
        		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
        };

        //TEST
        System.out.println(AlphaNumericToNumeric.convert(vigenereGen));
        
        for(int i=0;i<26;i++) {
        	char[] chrs=Arrays.copyOf(chrsmaster, 26);
        	for(int j=26;j>0;j--) {
        		int inte = mt.nextInt(j);
        		char c = chrs[inte];
        		chrs[inte]=chrs[j-1];
        		vigenereKey[i][j-1]=(char)(c);
        	}
        }
        // TEST
        System.out.print(" ||");
        for(int i=0;i<26;i++) System.out.print((char)(i+65)+" ");
        System.out.println();
        System.out.print("=||");
        for(int i=0;i<26;i++) System.out.print("==");
        System.out.println();
        char[] cs;
        for(int i=0;i<vigenereKey.length;i++) {
        	cs=vigenereKey[i];
            System.out.print((char)(i+65)+"||");
        	for(char c:cs) {
        		System.out.print(c+" ");
        	}
        	System.out.println();
        }
        


        while(true) {
        	System.out.println("Enter input:");
            input = br.readLine();
            System.out.println("Enter a keyword:");
            keyword = br.readLine();
            
            char[] ichars=input.toCharArray();
            char[] kchars=keyword.toCharArray();
            StringBuilder retn=new StringBuilder();

            int ik=0;   
            int length=kchars.length;
            // for warping to the beginning for the keyword
            
            System.out.println("Encrypt or Decrypt? (E/D)");
            if(br.readLine().equalsIgnoreCase("e")) {


            	for(char c:ichars) {
            		char k = kchars[ik];
            		ik++;
            		if(!(ik<length)) ik=0;
            		// looping
            		retn.append(
            				vigenereKey[getNum(k)][getNum(c)]
            		);
            		// add it
            	}
            	System.out.println(retn.toString());
            	
            } else {
            	// decrypt
            	
            	for(char c:ichars) {
            		if(Character.isLowerCase(c))c=Character.toUpperCase(c);
            		char currentkeywordletter = kchars[ik];
            		ik++;
            		if(!(ik<length)) ik=0;
            		// looping
            		char[] chrs = vigenereKey[getNum(currentkeywordletter)];
            		for(int i=0;i<chrs.length;i++) {
            			if(chrs[i]==c) {
            				retn.append((char)(i+65));
            			}
            		}
            	}
            	System.out.println(retn.toString());
            }
        }
       
       
    }
    public static int getNum(char c) {
        if(Character.isLowerCase(c)) return (c-'a');
        else return (c-'A');
    }
}