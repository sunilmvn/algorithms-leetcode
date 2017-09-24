package algorithms.leetcode.datastructures;

public class TreeNode<T> {
	T t;
	public TreeNode<T> right;
	public TreeNode<T> left;
	
	public TreeNode(T t){
		this.t = t;
	}
	
	public T getValue(){
		return t;
	}
}
