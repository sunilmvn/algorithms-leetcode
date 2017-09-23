package algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import algorithms.leetcode.datastructures.Queue;

/** 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to 
 * endWord, such that:
   Only one letter can be changed at a time
   Each intermediate word must exist in the word list
 For example,
Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 * @author sumukkav
 *
 */
public class WordLadder {
	private char[] chars = {'a','b','c','d','e',
							'f','g','h','i','j',
							'k','l','m','n','o',
							'p','q','r','s','t',
							'u','v','w','x','y',
							'z'};
	private Map<String, List<String>> map = new HashMap<String, List<String>>();
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)){
        	return 0;
        }
        List<String> retList = getLadder(beginWord, endWord, wordList);
        if(retList == null || retList.isEmpty())
        	return 0;
        return retList.size();
    }
	
	public List<String> getLadder(String beginWord, String endWord, Set<String> wordList){
		wordList.add(endWord);
		Queue<String> q = new Queue<String>();
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		q.push(beginWord);
		List<String> currDist = new ArrayList<String>();
		currDist.add(beginWord);
		map.put(beginWord, currDist);
		while(q.getCount() != 0){
			String s = q.pop();
			if(s.equals(endWord)){
				return map.get(s);
			}
			List<String> neighbors = getClosestWords(s, wordList);
			for(String s1: neighbors){
				if (!map.containsKey(s1)){
					q.push(s1);
					List<String> dist = new ArrayList<String>();
					dist.addAll(map.get(s));
					dist.add(s1);
					map.put(s1, dist);
				}
			}
		}
		return null;
	}
	
	public List<String> getClosestWords(String s, Set<String> wordList){
		System.out.println("Getting closest words for "+s);
		List<String> retList = new ArrayList<String>();
		char[] c = s.toCharArray();
		for(int j=0;j<c.length;j++){
			char temp = c[j];
			for(int k=0;k<chars.length;k++){
				c[j] = chars[k];
				String trans = String.valueOf(c);
				if(wordList.contains(trans) && !trans.equals(s)){
					System.out.println("Found word in Set "+trans);
					retList.add(trans);
				}
			}
			c[j] = temp;
		}
		return retList;
	}
	
	public static void main(String[] args){
		WordLadder wl = new WordLadder();
		Set<String> newSet = new HashSet<String>();
		newSet.add("hot");
		newSet.add("dot");
		newSet.add("dog");
		newSet.add("lot");
		newSet.add("log");
		System.out.println(wl.ladderLength("hit", "cog", newSet));
	}
}
