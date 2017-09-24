package algorithms.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/** 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating 
 * characters. For example, the longest substring without repeating letters 
 * for "abcabcbb" is "abc", which the length is 3. 
 * 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author sumukkav
 *
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int st = 0;
        int end = 0;
        Map<Character, Integer> cmap = new HashMap<Character, Integer>();
        char[] c = s.toCharArray();
        int i = 0;
        while(i<c.length){
        	if(cmap.containsKey(c[i])){
        		cmap.put(c[i], cmap.get(c[i])+1);
        		//Move st until the repeater char becomes 1 in map again
        		boolean quit = false;
        		while(!quit){
        			if(cmap.get(c[st]) == 2){
        				cmap.put(c[st], 1);
        				st++;
        				quit = true;
        			}
        			else{
        				cmap.remove(c[st]);
        				st++;
        			}
        		}
        	}
        	else{
        		cmap.put(c[i], 1);
        	}
        	end = i;
        	i++;
        	ret = Math.max(ret, end-st+1);
        }
        return ret;
    }
	
	public static void main(String[] args){
		LongestSubstring ss = new LongestSubstring();
		System.out.println(ss.lengthOfLongestSubstring("bbbbbbb"));
	}
}
