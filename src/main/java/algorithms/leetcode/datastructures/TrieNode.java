package algorithms.leetcode.datastructures;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public Character val;
	public Map<Character, TrieNode> children;
	public boolean isLeaf;
	
	public TrieNode(){
		val = null;
		children = new HashMap<Character, TrieNode>();
	}
}
