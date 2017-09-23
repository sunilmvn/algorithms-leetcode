package algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/** 68. Text Justification
 * Given an array of words and a length L, format the text such that each
 *  line has exactly L characters and is fully (left and right) justified.

	You should pack your words in a greedy approach; that is, pack as many words
 	as you can in each line. Pad extra spaces ' ' when necessary so that each 
 	line has exactly L characters.

	Extra spaces between words should be distributed as evenly as possible. If 
	the number of spaces on a line do not divide evenly between words, the 
	empty slots on the left will be assigned more spaces than the slots on 
	the right.

	For the last line of text, it should be left justified and no extra space
	is inserted between words.

	For example,
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.
	
	Return the formatted lines as:
	[
   "This    is    an",
   "example  of text",
   "justification.  "
	]
 * @author sumukkav
 *
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		//My assumption - Return null if any word length is greater than maxWidth 
		if(words.length == 0){
			return null;
		}
        List<String> s = new ArrayList<String>();
        int i = 0;
        int st = 0;
        int end = 0;
        int len = 0;
        boolean newline = true;
        while(i<words.length){
        	if(newline){
        		len = 0;
        		st = i;
        	}
        	else{
        		len = len+1;
        	}
        	if(len+words[i].length() <= maxWidth){
        		len = len+words[i].length();
        		newline = false;
        		//What if this is the last word
        		if(i == words.length-1){
        			end = i;
            		s.add(populateLine(words, st, end, maxWidth, true));
        		}
        		i++;
        	}
        	else{
        		newline = true;
        		end = i-1;
        		s.add(populateLine(words, st, end, maxWidth, false));
        	}
        }
        return s;
    }
	
	public String populateLine(String[] words, int st, int end, int maxWidth, boolean last){
		//System.out.println("Start and end are "+st+" "+end);
		if(st == end){
			StringBuffer sbBuffer = new StringBuffer();
			sbBuffer.append(words[st]);
			for(int i=0;i<maxWidth-words[st].length();i++){
				sbBuffer.append(" ");
			}
			return sbBuffer.toString();
		}
		if(last){
			StringBuffer sbBuffer = new StringBuffer();
			sbBuffer.append(words[st]);
			int currLength = words[st].length();
			for(int j=st+1;j<=end;j++){
				sbBuffer.append(" ");
				sbBuffer.append(words[j]);
				currLength = currLength+words[j].length()+1;
			}
			while(currLength<maxWidth){
				sbBuffer.append(" ");
				currLength++;
			}
			return sbBuffer.toString();
		}
		int totwords = end - st + 1;
		int totlength = 0;
		int curr = st;
		while(curr<=end){
			totlength = totlength+words[curr].length();
			curr++;
		}
		int totspaces = maxWidth-totlength;
		int noOfSpaceSlots = totwords-1;
		int noOfSpacesPerSlot = totspaces/noOfSpaceSlots;
		int extraSpaces = totspaces%noOfSpaceSlots;
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append(words[st]);
		for(int i=0;i<noOfSpaceSlots;i++){
			for(int j=0;j<noOfSpacesPerSlot;j++){
				sbBuffer.append(" ");
			}
			if(extraSpaces > 0){
				sbBuffer.append(" ");
				extraSpaces--;
			}
			sbBuffer.append(words[st+1+i]);
		}
		return sbBuffer.toString();
	}
	
	public static void main(String[] args){
		TextJustification tj = new TextJustification();
		//String[] words = {"This", "is", "an", "example", "of", "text", "justification.", "This", "Is", "My", "Sunil", "Kumar"};
		String[] words = {"What","must","be","shall","be."};
		List<String> list = tj.fullJustify(words, 12);
		for(int k=0;k<list.size();k++){
			System.out.println(list.get(k));
		}
	}
}
