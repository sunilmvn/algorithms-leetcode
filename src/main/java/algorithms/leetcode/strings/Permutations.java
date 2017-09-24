package algorithms.leetcode.strings;

public class Permutations {
	
	public static void printPermutations(String s){
		calculatePermutations(s.toCharArray(), 0);
	}
	
	private static void calculatePermutations(char[] c, int st){
		if(st == c.length-1){
			System.out.println(String.valueOf(c));
		}
		for(int i=st;i<c.length;i++){
			calculatePermutations(c, st+1);
			rotateChars(c, st);
		}
	}
	
	private static char[] rotateChars(char[] c, int i){
		char temp = c[i];
		for(int j=i;j<c.length-1;j++){
			c[j] = c[j+1];
		}
		c[c.length-1] = temp;
		return c;
	}
	
	public static void main(String[] args){
		//String s = String.valueOf(rotateChars("Sunil".toCharArray(), 0));
		//System.out.println(s);
		printPermutations("abcd");
	}

}
