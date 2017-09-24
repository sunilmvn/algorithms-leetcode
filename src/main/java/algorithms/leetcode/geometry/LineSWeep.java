package algorithms.leetcode.geometry;

import algorithms.leetcode.datastructures.Line;
import algorithms.leetcode.datastructures.Point;

public class LineSWeep {
	
	//http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
	/*
	 * To check if two lines intersect, we need to check the orientation
	 */
	public static boolean intersect(Line l1, Line l2){
		int o1 = orientation(l1.st, l1.end, l2.st);
		int o2 = orientation(l1.st, l1.end, l2.end);
		int o3 = orientation(l2.st, l2.end, l1.st);
		int o4 = orientation(l2.st, l2.end, l1.end);
		
		if(o1 != o2 && o3 != o4){
			return true;
		}
		
		// Special Cases
	    // l1.st, l1.end and l2.st are colinear and l2.st lies on segment l1
	    if (o1 == 0 && onSegment(l1.st, l2.st, l1.end)) return true;
	 
	    // l1.st, l1.end and l2.end are colinear and l2.end lies on segment l1
	    if (o2 == 0 && onSegment(l1.st, l2.end, l1.end)) return true;
	 
	    // l2.st, l2.end and l1.st are colinear and l1.st lies on segment l2
	    if (o3 == 0 && onSegment(l2.st, l1.st, l2.end)) return true;
	 
	     // l2.st, l2.end and l1.end are colinear and l1.end lies on segment l2
	    if (o4 == 0 && onSegment(l2.st, l1.end, l2.end)) return true;
		
		return false;
	}
	
	// To find orientation of ordered triplet (p, q, r).
	// The function returns following values
	// 0 --> p, q and r are colinear
	// 1 --> Clockwise
	// 2 --> Counterclockwise
	public static int orientation(Point p, Point q, Point r){
		int res = ((q.y-p.y)*(r.x-q.x)) - ((r.y-q.y)*(q.x-p.x));
		if(res == 0){
			//All three points are in straight line
			return 0;
		}
		return (res>0)?1:2; //clockwise or anti-clockwise
	}
	
	// Given three colinear points p, q, r, the function checks if
	// point q lies on line segment 'pr'
	public static boolean onSegment(Point p, Point q, Point r)
	{
	    if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
	        q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
	       return true;
	    return false;
	}
	
	
}
