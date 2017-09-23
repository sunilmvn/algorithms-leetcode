package algorithms.leetcode.datastructures;

public class Meeting {
	public int start;
	public int end;
	public Meeting(int s, int e) { start = s; end = e; }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+start+","+end+")";
	}
}
