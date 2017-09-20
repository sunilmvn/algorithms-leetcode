package algorithms.leetcode.strings;

/** 214. Shortest Palindrome
 * Given a string S, you are allowed to convert it to a palindrome by 
 * adding characters in front of it. Find and return the shortest 
 * palindrome you can find by performing this transformation.
For example:
Given "aacecaaa", return "aaacecaaa".
Given "abcd", return "dcbabcd".
 * @author sumukkav
 *
 */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if(s.length() == 0 || s.length() == 1){
			return s;
		}
		char[] c = s.toCharArray();
		int second = c.length/2;
		int first = second;
		if(c.length%2 == 0){
			first = first-1;
		}
		int ast = first;
		int bst = second;
		while(first>=0){
			if(c[first] == c[second]){
				first--;
				second++;
			}
			else{
				if(ast == bst){
					ast--;
				}
				else{
					bst = ast;
				}
				first = ast;
				second = bst;
			}
		}
		char[] d = new char[c.length-second];
		int i = 0;
		for(int j = c.length-1;j>=second;j--){
			d[i] = c[j];
			i++;
		}
		String result = String.valueOf(d)+String.valueOf(c);
		return result;
	}
	
	public static void main(String[] args){
		String s = "aacecaaa";
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println("Shortest Palindrome for "+ s + ": " +sp.shortestPalindrome(s));
	}
}
