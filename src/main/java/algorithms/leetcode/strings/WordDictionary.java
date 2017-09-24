package algorithms.leetcode.strings;

import java.util.Map;

import algorithms.leetcode.datastructures.TrieNode;

/** 211. Add and Search Word - Data Structure Design
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string 
   containing only letters a-z or .. A . means it can represent any one letter.
 * For example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 * @author sumukkav
 *
 */
public class WordDictionary {
	private TrieNode root;
	public WordDictionary() {
		// TODO Auto-generated constructor stub
		root = new TrieNode();
	}
	
	private void insertChar(TrieNode r, String word, int i){
    	if(i == word.length()){
    		r.isLeaf = true;
    		return;
    	}
    	TrieNode n1 = findNodeWithChar(r, word.charAt(i));
    	if(n1 != null){
    		insertChar(n1, word, i+1);
    	}
    	else{
    		addChar(r, word, i);
    	}
    }
    
    private TrieNode findNodeWithChar(TrieNode r, char c){
    	Map<Character, TrieNode> children = r.children;
    	if(children.containsKey(c)){
    		return children.get(c);
    	}
    	return null;
    }
    
    private void addChar(TrieNode r, String s, int i){
    	TrieNode curr = r;
    	while(i < s.length()){
    		TrieNode t = new TrieNode();
    		t.val = s.charAt(i);
    		curr.children.put(s.charAt(i), t);
    		curr = t;
    		i++;
    	}
    	curr.isLeaf = true;
    }
    
    private boolean regexSearch(TrieNode t, String s, int i){
    	Map<Character, TrieNode> children = t.children;
    	if(i == s.length()){
    		return t.isLeaf;
    	}
    	if(children.containsKey(s.charAt(i))){
    		return regexSearch(children.get(s.charAt(i)), s, i+1);
    	}
    	else if(s.charAt(i) == '.'){
    		for(TrieNode n : children.values()){
    			boolean result = regexSearch(n, s, i+1);
    			if(result){
    				return result;
    			}
    			else{
    				continue;
    			}
    		}
    	}
    	return false;
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        insertChar(root, word, 0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return regexSearch(root, word, 0);
    }
    
    public static void main(String[] args){
    	WordDictionary wd = new WordDictionary();
    	wd.addWord("bad");
    	wd.addWord("dad");
    	wd.addWord("mad");
    	System.out.println(wd.search("ma."));
    	System.out.println(wd.search("bad"));
    	System.out.println(wd.search(".ad"));
    	System.out.println(wd.search("..."));
    }
}
