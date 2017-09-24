package algorithms.leetcode.design;

import java.util.HashMap;

import algorithms.leetcode.datastructures.LinkedListNode;

/**
 * LeetCode - 146
 * Description: Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set - 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently 
 * used item before inserting a new item.
 * @author sumukkav
 *
 */
public class LRUCache {
	private LinkedListNode<Integer> first;
	private LinkedListNode<Integer> last;
	private HashMap<Integer, LinkedListNode<Integer>> map;
	private int total = 0;
	private int capacity;
	public LRUCache(int capacity) {
        map = new HashMap<Integer, LinkedListNode<Integer>>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (total == 0){
        	return -1;
        }
        else{
        	LinkedListNode<Integer> node = map.get(key);
        	if(node == null){
        		return -1;
        	}
        	else{
        		resetList(node);
        		return node.getValue();
        	}
        }
    }
    
    private void resetList(LinkedListNode<Integer> i){
    	if(i.next == null){
    		return;
    	}
    	LinkedListNode<Integer> temp = i.next;
    	i.prev.next = temp;
    	while(temp.next != null){
    		temp = temp.next;
    	}
    	temp.next = i;
    	i.prev = temp;
    	i.next = null;
    	last = i;
    }
    
    //Last used will always be the first
    private void removeLastUsed(){
    	first = first.next;
    	total--;
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		return;
    	}
    	LinkedListNode<Integer> node = new LinkedListNode<Integer>(value);
        if(total == 0){
        	first = node;
        	last = node;
        	map.put(key, node);
        	total++;
        	return;
        }
        else {
        	if(total == capacity){
        		System.out.println("Cache Overflow!!");
        		removeLastUsed();
        	}
        	last.next = node;
        	node.prev = last;
        	last = node;
        	map.put(key, node);
        	total++;
        	return;
        }
    }
    
    public void printCache(){
    	System.out.println("Cache Total: "+total);
    	LinkedListNode<Integer> curr = first;
    	while(curr != null){
    		System.out.print(curr.getValue()+" ");
    		curr = curr.next;
    	}
    	System.out.println();
    }
    
    public static void main(String[] args){
    	LRUCache cache = new LRUCache(5);
    	cache.set(10, 10);
    	cache.printCache();
    	cache.set(12, 12);
    	cache.printCache();
    	cache.set(14,14);
    	cache.printCache();
    	System.out.println("Getting: "+cache.get(12));
    	cache.printCache();
    	cache.set(12, 12);
    	cache.printCache();
    	cache.set(16, 16);
    	cache.set(17, 17);
    	cache.set(19, 19);
    	cache.printCache();
    	
    }

}
