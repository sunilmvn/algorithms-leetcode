package algorithms.leetcode.datastructures;

public class LinkedListNode<T> {
	public LinkedListNode(T t){
		this.t = t;
	}
	T t;
	public LinkedListNode<T> next;
	public LinkedListNode<T> prev;
	public T getValue(){
		return t;
	}
}
