package algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	public static List<String> returnAllCombinations(String s){
		return getCombinations(s, 0, s.length()-1);
	}
	
	public static List<String> getCombinations(String s, int st, int end){
		List<String> sList = new ArrayList<String>();
		if(st == end){
			sList.add(s.substring(st, end+1));
			return sList;
		}
		else{
			List<String> tempList = getCombinations(s, st, end-1);
			for(String s1 : tempList){
				sList.add(s1);
				String s2 = s1+s.substring(end,end+1);
				sList.add(s2);
			}
			System.out.println();
			sList.add(s.substring(end,end+1));
		}
		return sList;
	}
	
	public static void main(String[] args){
		List<String> res = returnAllCombinations("abc");
		System.out.println("Combinations are");
		for (String s : res){
			System.out.println(s);
		}
	}

}
