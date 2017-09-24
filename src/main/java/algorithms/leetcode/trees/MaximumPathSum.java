package algorithms.leetcode.trees;

import algorithms.leetcode.datastructures.TreeNode;

/** 124. Binary Tree Maximum Path Sum
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes 
from some starting node to any node in the tree along the parent-child 
connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * @author sumukkav
 *
 */
public class MaximumPathSum {
	int maxValue = Integer.MIN_VALUE;
	private int maxPathSumWrapper(TreeNode<Integer> root) {
        if(root == null){
			return 0;
		}
		int maxLeft = maxPathSumWrapper(root.left);
		System.out.println("max from left "+maxLeft);
		int maxRight = maxPathSumWrapper(root.right);
		System.out.println("max from right "+maxRight);
		if(maxLeft+maxRight+root.getValue() > maxValue){
			maxValue = maxLeft+maxRight+root.getValue();
		}
		int maxUptoNode = Math.max(maxLeft, maxRight);
		if(root.getValue() < maxUptoNode+root.getValue()){
			maxUptoNode = maxUptoNode+root.getValue();
		}
		else{
			maxUptoNode = root.getValue();
		}
		maxValue = Math.max(maxValue, maxUptoNode);
		return maxUptoNode;
    }
	
	public int maxPathSum(TreeNode<Integer> root) {
		return Math.max(maxPathSumWrapper(root), maxValue);
	}
	
	public static void main(String[] args){
		MaximumPathSum mp = new MaximumPathSum();
		TreeNode<Integer> r = new TreeNode<Integer>(1);
		TreeNode<Integer> r1 = new TreeNode<Integer>(2);
		TreeNode<Integer> r2 = new TreeNode<Integer>(3);
		r.left = r1;
		r.right = r2;
		System.out.println(mp.maxPathSum(r));
	}
}
