package main.vigenere;
import java.util.Random;

public class DiacriticsMain {
	public static void main(String[] args) { 
	StringBuilder str = new StringBuilder("a");
	int NUM=4;
	for(int k=0;k<NUM;k++) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<99;j++) {
				Random rand = new Random();
				int in = rand.nextInt(110) + 769;
				str.append((char)in);
			}
		}
		System.out.print(str.toString());
		str = new StringBuilder("a");
	}
	}
}
