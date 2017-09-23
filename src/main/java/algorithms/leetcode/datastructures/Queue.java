package algorithms.leetcode.datastructures;

public class Queue<T> {
	public Queue(){
		count = 0;
	}
	private int count;
	private QueueNode<T> head;
	private QueueNode<T> tail;
	public T pop(){
		if(head != null){
			T ret = head.t;
			if(tail == head){
				tail = tail.next;
			}
			head = head.next;
			count --;
			return ret;
		}
		else{
			return null;
		}
	}
	
	public void push(T t){
		QueueNode<T> node = new QueueNode<T>(t);
		if(tail != null){
			tail.next = node;
			node.prev = tail;
		}
		else{
			head = node;
		}
		tail = node;
		count++;
	}
	
	public int getCount(){
		return count;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}

class QueueNode<T>{
	T t;
	QueueNode<T> next;
	QueueNode<T> prev;
	QueueNode(T t){
		this.t = t;
	}
}
