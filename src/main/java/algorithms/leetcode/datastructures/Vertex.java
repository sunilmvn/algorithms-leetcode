package algorithms.leetcode.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	private T t;
	private List<Vertex<T>> friends;
	public boolean visited;
	public Vertex(T t){
		this.t = t;
		this.visited = false;
		this.friends = new ArrayList<Vertex<T>>();
	}
	public T getValue(){
		return t;
	}
	public void addFriend(Vertex<T> v){
		friends.add(v);
	}
	public List<Vertex<T>> getFriends(){
		return friends;
	}
}
