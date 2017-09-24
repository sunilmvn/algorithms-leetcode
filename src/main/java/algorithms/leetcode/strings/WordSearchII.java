package algorithms.leetcode.strings;

import java.util.List;
import java.util.Map;

import algorithms.leetcode.datastructures.TrieNode;

/** 212. Word Search II
 * Given a 2D board and a list of words from the dictionary, 
 * find all words in the board.

 * Each word must be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
 * @author sumukkav
 *
 */
public class WordSearchII {
	TrieNode root;
	
	private boolean prefixExists(TrieNode t, String s, int i){
    	if(i == s.length()){
    		return true;
    	}
    	Map<Character, TrieNode> children = t.children;
    	if(children.containsKey(s.charAt(i))){
    		return prefixExists(children.get(s.charAt(i)), s, i+1);
    	}
    	return false;
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
    
    // Adds a word into the data structure.
    private void addWord(String word) {
        insertChar(root, word, 0);
    }
	
	 // Returns if there is any word in the trie
    // that starts with the given prefix.
    private boolean startsWith(String prefix) {
        return prefixExists(root, prefix, 0);
    }
    
    public List<String> findWords(char[][] board, String[] words) {
		return null;
    }

}


