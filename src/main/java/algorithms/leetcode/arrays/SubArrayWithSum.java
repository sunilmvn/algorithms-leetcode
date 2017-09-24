package algorithms.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * 560. Given an array of integers and an integer k, you need to find the 
 * total number of continuous subarrays whose sum equals to k.
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * Find all sub arrays in an array which sums upto the given value
 *  -- given a non-negative array
 * @author sumukkav
 * int array[] = { 3, 5, 6, 9, 14, 8, 2, 12, 7, 7 }; printSubArrayOfRequiredSum(array, 14);
 * Output : sum : 14 array : [ 3, 5, 6, ] sum : 14 array : [ 14, ] 
 * sum : 14 array : [ 2, 12, ] sum : 14 array : [ 7, 7, ]
 * 
 * Follow up to this question would be, what if it's a negative array
 */
public class SubArrayWithSum {
	public int getSumWithIndexes(int[] a, int val){
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int sum = 0;
		int tot = 0;
		for(int i=0;i<a.length;i++){
			if(a[i] == val){
				
			}
			sum = sum+a[i];
			if(map.containsKey(sum)){
				List<Integer> sumarr = map.get(sum);
				sumarr.add(i);
				if(sum == val){
					System.out.println("Start index is 0 and End Index is "+i);
					tot++;
					for(int j : sumarr){
						System.out.println("Start index is "+(j+1)+" End Index is "+i);
						tot++;
					}
				}
			}
			else{
				List<Integer> indexList = new ArrayList<Integer>();
				indexList.add(i);
				map.put(sum, indexList);
				if(sum == val){
					System.out.println("Start index is 0 and End Index is "+i);
					tot++;
				}
			}
			if(map.containsKey(sum-val)){
				List<Integer> sumval = map.get(sum-val);
				for(int k : sumval){
					System.out.println("Start index is "+(k+1)+" End Index is "+i);
					tot++;
				}
			}
		}
		return tot;
	}
	
	public static void main(String[] args){
		SubArrayWithSum saws = new SubArrayWithSum();
		int array[] = { 3, 5, 6, 9, 14, 8, 2, 12, 7, 7 };
		System.out.println("No of sub arrays are "+saws.getSumWithIndexes(array, 14));
	}
}
