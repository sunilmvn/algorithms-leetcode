package algorithms.leetcode.datastructures;

public class Stack<T> {
	StackNode<T> head;
	private int count;
	public Stack(){
		count = 0;
	}
	
	public T pop(){
		if(head == null){
			return null;
		}
		else{
			T ret = head.t;
			head = head.next;
			count--;
			return ret;
		}
	}
	
	public void push(T t){
		StackNode<T> node = new StackNode<T>(t);
		if(head == null){
			head = node;
		}
		else{
			node.next = head;
			head = node;
		}
		count++;
	}
	
	public T peek(){
		if(head == null){
			return null;
		}
		else{
			return head.t;
		}
	}
	
	public int getCount(){
		return count;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		StackNode<T> curr = head;
		while(curr != null){
			sb.append(curr.t+" ");
			curr = curr.next;
		}
		return sb.toString();
	}
}

class StackNode<T>{
	T t;
	StackNode<T> next;
	StackNode(T t){
		this.t= t;
	}
}
