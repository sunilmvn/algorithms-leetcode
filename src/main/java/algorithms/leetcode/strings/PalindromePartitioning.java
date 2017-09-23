package algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
    ["aa","b"],
    ["a","a","b"]
  ]
 * @author sumukkav
 *
 */
public class PalindromePartitioning {
	Map<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
	public List<List<String>> partition(String s){
		System.out.println("Returning lists for "+s);
		if(map.containsKey(s)){
			System.out.println("Contains "+s);
			return map.get(s);
		}
		List<List<String>> mylist = new ArrayList<List<String>>();
		if(s.length() == 1){
			List<String> k = new ArrayList<String>();
			k.add(s);
			mylist.add(k);
			map.put(s, mylist);
			return mylist;
		}
		for(int i=0;i<s.length()-1;i++){
			boolean firstHalf = isPalindrome(s.substring(0, i+1));
			
			if(firstHalf){
				List<List<String>> retList = partition(s.substring(i+1));
				List<List<String>> secondHalf = 
						appendStringToList(s.substring(0, i+1), retList);
				mylist.addAll(secondHalf);
			}
		}
		//Check if the whole String is Palindrome
		if(isPalindrome(s)){
			List<String> s2 = new ArrayList<String>();
			s2.add(s);
			mylist.add(s2);
		}
		map.put(s, mylist);
		return mylist;
	}
	
	public List<List<String>> appendStringToList(String s1, List<List<String>> mylist){
		System.out.print("Appending "+s1+" ");
		List<List<String>> newList = new ArrayList<List<String>>();
		for(int j=0;j<mylist.size();j++){
			List<String> inner = mylist.get(j);
			List<String> innerList = new ArrayList<String>();
			innerList.add(s1);
			innerList.addAll(inner);
			newList.add(innerList);
		}
		return newList;
	}
	
	public boolean isPalindrome(String s){
		if(s.length() == 1){
			return true;
		}
		char[] c = s.toCharArray();
		boolean isPalindrome = true;
		for(int i=0,j=c.length-1;i<=j;i++,j--){
			if(c[i] != c[j]){
				isPalindrome = false;
				break;
			}
		}
		System.out.println("Is "+s+" a Palindrome? "+isPalindrome);
		return isPalindrome;
	}
	
	private void printList(List<String> mylist){
		System.out.print("List is ");
		for(int j=0;j<mylist.size();j++){
			System.out.print(mylist.get(j)+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		String s = "abaccaba";
		PalindromePartitioning ps = new PalindromePartitioning();
		List<List<String>> retLists = ps.partition(s);
		for(int i=0;i<retLists.size();i++){
			ps.printList(retLists.get(i));
		}
	}
}
