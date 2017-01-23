package main;

public class AlphaNumericToNumeric {
	public static long convert(String info) {
		char[] cs = info.toCharArray();
		long retncode=0;
		int j=0;
		for(int i=cs.length-1;i>=0;i--) {
			char c = cs[i];
			if(Character.isDigit(c))c-=('0'-1);
			else if(Character.isLowerCase(c))c-=('a'-37);
			else c-=('A'-11);
			// subtract to A, add 10 to account for the num difference
			retncode += c * pow(62,j);
			j++;
		}
		return retncode;
	}
	public static long pow(int base, int exponent) {
		int retn=1;
		if(exponent==0) return 1;
		for(int i=0;i<exponent;i++) {
			retn*=base;
		}
		return retn;
	}	
}
