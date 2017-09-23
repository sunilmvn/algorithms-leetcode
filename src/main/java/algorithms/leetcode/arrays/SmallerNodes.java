package algorithms.leetcode.arrays;

import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller 
 * elements to the right of nums[i].
 * Example: Given nums = [5, 2, 6, 1]
 * * To the right of 5 there are 2 smaller elements (2 and 1).
 * * To the right of 2 there is only 1 smaller element (1).
 * * To the right of 6 there is 1 smaller element (1).
 * * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 * @author sumukkav
 *
 */
public class SmallerNodes {
	public List<Integer> countSmaller(int[] nums) {
        return null;
    }
	
	private SegmentNode createSubTree(int[] nums, int st, int end){
		SegmentNode s = new SegmentNode();
		if(st == end){
			s.val = nums[st];
			s.noOfSmallerNodes = 0;
			return s;
		}
		int mid = (st+end)/2;
		return s;
	}
}

class SegmentNode{
	int val;
	int noOfSmallerNodes;
}
