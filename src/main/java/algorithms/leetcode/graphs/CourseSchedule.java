package algorithms.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

import algorithms.leetcode.datastructures.Vertex;

/** 207. Course Schedule
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have 
 * to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, 
 * is it possible for you to finish all courses?

 * For example:
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 
 * you should have finished course 0. So it is possible.

 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 
 * 1 you should have finished course 0, and to take course 0 you should 
 * also have finished course 1. So it is impossible.
 * @author sumukkav
 *
 */
public class CourseSchedule {
	List<Vertex<Integer>> courseList;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		courseList = new ArrayList<Vertex<Integer>>();
		//Add courses
		for(int i = 0;i<numCourses;i++){
			Vertex<Integer> v = new Vertex<Integer>(i);
			courseList.add(v);
		}
		//Add Edges
		for(int j=0;j<prerequisites.length;j++){
			int[] dep = prerequisites[j];
			Vertex<Integer> e = courseList.get(dep[1]);
			Vertex<Integer> f = courseList.get(dep[0]);
			e.addFriend(f);
		}
		for(Vertex<Integer> v : courseList){
			if(!isDirected(v)){
				return false;
			}
		}
		return true;
    }
	public boolean isDirected(Vertex<Integer> v){
		if(v.visited){
			return false;
		}
		//Setting all the nodes in the path from current node
		// to the end node to true
		//If any of the nodes in it's path is visited again,
		//the tree is expected to have a cycle
		v.visited = true;
		List<Vertex<Integer>> friends = v.getFriends();
		for(Vertex<Integer> v1 : friends){
			if(!isDirected(v1)){
				return false;
			}
		}
		//Setting the current node to false
		v.visited = false;
		return true;
	}
	
	public static void main(String[] args){
		CourseSchedule cs = new CourseSchedule();
		int[][] dep = {{1,0},{0,2}};
		System.out.println("Can Finish? "+cs.canFinish(3, dep));
	}
}
