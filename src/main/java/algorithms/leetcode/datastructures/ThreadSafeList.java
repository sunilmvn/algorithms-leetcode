package algorithms.leetcode.datastructures;

public class ThreadSafeList {
	private int CAPACITY;
	private int count = 0;
	LinkedListNode<Integer> head;
	LinkedListNode<Integer> tail;
	
	public ThreadSafeList(int num){
		this.CAPACITY = num;
	}
	
	public void enqueue(int val) throws InterruptedException{
		addToQueue(val);
		count++;
	}
	
	public int dequeue() throws InterruptedException{
		count--;
		return removeFromQueue();
	}
	
	private void addToQueue(int val){
		LinkedListNode<Integer> l = new LinkedListNode<Integer>(val);
		if(head == null){
			head = l;
			tail = l;
		}
		else{
			l.next = head;
			head.prev = l;
			head = l;
		}
	}
	
	private int removeFromQueue(){
		if(tail == null){
			return -1;
		}
		int ret = tail.getValue();
		if(head == tail){
			head = null;
		}
		tail = tail.prev;
		return ret;
	}
	
	public boolean isEmpty(){
		return (count == 0);
	}
	
	public boolean isFull(){
		return (count == CAPACITY);
	}

}
