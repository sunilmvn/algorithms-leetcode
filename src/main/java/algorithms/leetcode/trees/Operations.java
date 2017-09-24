package algorithms.leetcode.trees;

import algorithms.leetcode.datastructures.Stack;

import algorithms.leetcode.datastructures.TreeNode;

/**
 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * InOrder Successor and Predecessor for Nodes in a BST
 * @author vmukkavilli
 *
 */
public class Operations {
	
	public static TreeNode<Integer> inOrderSuccessor(TreeNode<Integer> n, int v){
		TreeNode<Integer> ret = getSuccessor(n, v);
		if(ret == null) return null;
		return (ret.getValue() == v)? null : ret;
	}
	
	public static TreeNode<Integer> inOrderPredecessor(TreeNode<Integer> n, int val){
		TreeNode<Integer> ret = getPredecessor(n, val);
		if(ret==null) return null;
		return (ret.getValue()==val)?null:ret;
	}
	
	public static boolean findPath(TreeNode<Integer> r, TreeNode<Integer> t1, TreeNode<Integer> t2){
		if(r == null || t1 == null || t2 == null){
			return false;
		}
		Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
		return true;
	}
	
	private static boolean getPath(TreeNode<Integer> r, TreeNode<Integer> t1, 
			TreeNode<Integer> t2, Stack<TreeNode<Integer>> s) {
		if(r == null){
			return false;
		}
		boolean leftResult = getPath(r.left, t1, t2, s);
		if(leftResult){//Got both nodes and the path
			return true;
		}
		else{
			boolean rightResult = getPath(r.right, t1, t2, s);
			if(rightResult){//Got both nodes and the path
				return true;
			}
			else{
				
			}
		}
		return false;
	}
	
	private static TreeNode<Integer> getSuccessor(TreeNode<Integer> n, int v){
		if(n == null)
			return null;
		if(n.getValue() == v){
			if(n.right != null){
				return getLowest(n.right);
			}
			else{
				return n;
			}
		}
		TreeNode<Integer> t = getSuccessor(n.left, v);
		if(t != null){
			if(t.getValue() == v){
				return n;
			}
			else{
				return t;
			}
		}
		else{
			return getSuccessor(n.right, v);
		}
	}
	
	private static TreeNode<Integer> getLowest(TreeNode<Integer> n){
		if(n.left != null){
			return getLowest(n.left);
		}
		else{
			return n;
		}
	}
	
	private static TreeNode<Integer> getHighest(TreeNode<Integer> n){
		if(n.right != null){
			return getHighest(n.right);
		}
		else{
			return n;
		}
	}
	
	private static TreeNode<Integer> getPredecessor(TreeNode<Integer> t, int val){
		if(t == null){
			return null;
		}
		if(t.getValue() == val){
			if(t.left != null){
				return getHighest(t.left);
			}
			else{
				return t;
			}
		}
		TreeNode<Integer> ret = getPredecessor(t.right, val);
		if(ret != null){
			if(ret.getValue() == val){
				return t;//This will be the Predecessor
			}
			else{
				return ret;
			}
		}
		else{
			return getPredecessor(t.left, val);
		}
	}
	
	public static void main(String[] args){
		TreeNode<Integer> a = new TreeNode<Integer>(25);
		TreeNode<Integer> b = new TreeNode<Integer>(15);
		TreeNode<Integer> c = new TreeNode<Integer>(40);
		TreeNode<Integer> d = new TreeNode<Integer>(10);
		TreeNode<Integer> e = new TreeNode<Integer>(18);
		TreeNode<Integer> f = new TreeNode<Integer>(35);
		TreeNode<Integer> g = new TreeNode<Integer>(45);
		TreeNode<Integer> h = new TreeNode<Integer>(5);
		TreeNode<Integer> i = new TreeNode<Integer>(17);
		TreeNode<Integer> j = new TreeNode<Integer>(20);
		TreeNode<Integer> k = new TreeNode<Integer>(44);
		TreeNode<Integer> l = new TreeNode<Integer>(49);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		d.left = h;
		e.left = i;
		e.right = j;
		g.left = k;
		g.right = l;
		int val = 25;
		TreeNode<Integer> success = inOrderSuccessor(a, val);
		TreeNode<Integer> predecessor = inOrderPredecessor(a, val);
		if (success == null){
			System.out.println("No successor for "+val);
		}
		else{
			System.out.println("Successor for "+val+" is "+success.getValue());
		}
		if(predecessor == null){
			System.out.println("No Predecessor for "+val);
		}
		else{
			System.out.println("Predecessor for "+val+" is "+predecessor.getValue());
		}
	}

}
