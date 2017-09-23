package algorithms.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/** 76. Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will 
 * contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, 
return the empty string "".

If there are multiple such windows, you are guaranteed that there 
will always be only one unique minimum window in S.
 * @author sumukkav
 *
 */
public class MinimumWindow {
	public String minWindow(String s, String t) {
		if(s == null || t == null){
			return "";
		}
		if(s.length() == 0 ||
				t.length() == 0 ||
				s.length()<t.length()){
			return "";
		}
		char[] sarr = s.toCharArray();
		char[] tarr = t.toCharArray();
		Map<Character, Integer> maps = new HashMap<Character, Integer>();
		for(int i=0;i<t.length();i++){
			if(maps.containsKey(tarr[i])){
				maps.put(tarr[i], maps.get(tarr[i])+1);
			}
			else{
				maps.put(tarr[i], 1);
			}
		}
		int st = 0;
		int end = -1;
		int j = 0;
		while(j<sarr.length && !maps.isEmpty()){
			//Do while map becomes empty (populate end)
			//that means we have the substring with all the required characters
			//System.out.println("Printing j"+j);
			if(maps.containsKey(sarr[j])){
				maps.put(sarr[j], maps.get(sarr[j])-1);
				if(maps.get(sarr[j]) == 0){
					maps.remove(sarr[j]);
				}
			}
			j++;
		}
		if(maps.isEmpty()){
			end = j-1;
		}
		else{
			return "";
		}
		//Populate the map again, this time just populate the map
		//no need to populate the values
		for(int i=0;i<t.length();i++){
			if(!maps.containsKey(tarr[i])){
				maps.put(tarr[i], 0);
			}
		}
		//Minimize the existing substring by removing unrequired 
		//chars from the front (since st is 0)
		for(int k=st;k<end;k++){
			if(maps.containsKey(sarr[k])){
				break;
			}
			else{
				st++;
				continue;
			}
		}
		int fst = st;
		int fend = end;
		System.out.println("First Substring "+s.substring(fst, fend+1));
		//Now we have a substring with all chars,
		//traverse through the complete array to check if there is smaller substring with all the chars
		while(j<s.length()){
			System.out.println("j is "+j);
			/*
			 * This is required to this
			 * "ADOBECODEBA" we start from C and check for st (A) but we find B first
			 * ultimately when we find A and start moving st, we can ignore B since we already
			 * found it again.
			 */
			if(sarr[j]==sarr[st]){
				System.out.println("Searching for "+sarr[j]);
				end = j;
				st++;
				//Move until the next char matches the map key AND value 0
				boolean stop = false;
				while(!stop){
					if(maps.containsKey(sarr[st])){
						if(maps.get(sarr[st]) == 0){
							System.out.println("quitting for "+st);
							stop = true;
						}
						else{
							maps.put(sarr[st], maps.get(sarr[st])-1);
							st++;
						}
					}
					else{
						st++;
					}
				}
				System.out.println("New st and end "+st+" "+end);
			}
			else{
				//Increment the count of the map
				if(maps.containsKey(sarr[j])){
					System.out.println("Incrementing 1 for "+sarr[j]);
					maps.put(sarr[j], maps.get(sarr[j])+1);
				}
			}
			if(fend-fst > end-st){
				fst = st;
				fend = end;
			}
			j++;
		}
		System.out.println("st "+st+" end "+end);
		System.out.println("Final Substring "+s.substring(fst, fend+1));
        return "";
    }
	
	
	//Solution seen somewhere
	public String minWindow2(String s, String t) {
	    if(t.length()>s.length()) 
	        return "";
	    String result = "";
	 
	    //character counter for t
	    HashMap<Character, Integer> target = new HashMap<Character, Integer>();
	    for(int i=0; i<t.length(); i++){
	        char c = t.charAt(i);    
	        if(target.containsKey(c)){
	            target.put(c,target.get(c)+1);
	        }else{
	            target.put(c,1);  
	        }
	    }
	 
	    // character counter for s
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    int left = 0;
	    int minLen = s.length()+1;
	 
	    int count = 0; // the total of mapped characters
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	 
	        if(target.containsKey(c)){
	            if(map.containsKey(c)){
	                if(map.get(c)<target.get(c)){
	                    count++;
	                }
	                map.put(c,map.get(c)+1);
	            }else{
	                map.put(c,1);
	                count++;
	            }
	        }
	 
	        if(count == t.length()){
	            char sc = s.charAt(left);
	            while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
	                if (map.containsKey(sc) && map.get(sc) > target.get(sc))
	                    map.put(sc, map.get(sc) - 1);
	                left++;
	                sc = s.charAt(left);
	            }
	 
	            if (i - left + 1 < minLen) {
	                result = s.substring(left, i + 1);
	                minLen = i - left + 1;
	            }
	        }
	    }
	    System.out.println(result);
	    return result;
	}
	
	public static void main(String[] args){
		MinimumWindow mw = new MinimumWindow();
		//mw.minWindow("ADOBECODEBANC", "ABC");
		//mw.minWindow("THISISANICEPROBLEM", "ENC");
		//mw.minWindow("this is a test string", "tist");//This case not working
		//mw.minWindow2("ADOBECODEBANC", "ABC");
		//mw.minWindow2("THISISANICEPROBLEM", "ENC");
		mw.minWindow2("this is a test string", "tist");
	}
}
