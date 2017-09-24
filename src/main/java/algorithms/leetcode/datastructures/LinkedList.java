package algorithms.leetcode.datastructures;

public class LinkedList<T> {
	LinkedList(T t){
		this.head = new LinkedListNode<T>(t);
	}
	private LinkedListNode<T> head;
	public T head(){
		return this.head.t;
	}
}
