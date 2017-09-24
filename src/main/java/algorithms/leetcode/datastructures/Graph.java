package algorithms.leetcode.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
	private List<Vertex<T>> vertices;
	public Graph(){
		vertices = new ArrayList<Vertex<T>>();
	}
	public void addVertex(Vertex<T> v){
		vertices.add(v);
	}
	public void addEdge(Vertex<T> u, Vertex<T> v){
		u.addFriend(v);
	}
	public List<Vertex<T>> vertices(){
		return vertices;
	}
	public int length(){
		return vertices.size();
	}
}
