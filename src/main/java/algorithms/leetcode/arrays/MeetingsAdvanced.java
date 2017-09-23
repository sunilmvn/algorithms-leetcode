package algorithms.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algorithms.leetcode.datastructures.Meeting;

/**
 * Given a List of meetings (with start and end times), find the minimum no of
 * conference rooms required
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
 * @author sumukkav
 *
 */
public class MeetingsAdvanced {
	
	public static int getMaxRooms(List<Meeting> meetingList){
		if(meetingList == null || meetingList.size() == 0){
			return 0;
		}
		//Sort the meetings with the start time
		//Sort the meetings with the end time
		List<Meeting> startSortedList = new ArrayList<Meeting>(meetingList);
		List<Meeting> endSortedList = new ArrayList<Meeting>(meetingList);
		Collections.sort(startSortedList, new MeetingStartComparator());
		Collections.sort(endSortedList, new MeetingEndComparator());
		int maxRooms = 1;
		int rooms = 1;
		int i = 1, j = 0;
		while(i<startSortedList.size() && j < endSortedList.size()){
			Meeting startMeeting = startSortedList.get(i);
			Meeting endMeeting = endSortedList.get(j);
			if(startMeeting.start < endMeeting.end){
				rooms++;
				i++;
			}
			else{
				i++;
				j++;
			}
			maxRooms = Math.max(maxRooms, rooms);
		}
		return maxRooms;
	}
	
	public static void main(String[] args){
		List<Meeting> list = new ArrayList<Meeting>();
		list.add(new Meeting(2,4));
		list.add(new Meeting(3,6));
		list.add(new Meeting(4,8));
		list.add(new Meeting(5,7));
		list.add(new Meeting(1,5));
		System.out.println("Total Rooms required: "+MeetingsAdvanced.getMaxRooms(list));
	}

}

class MeetingStartComparator implements Comparator<Meeting>{
	public int compare(Meeting o1, Meeting o2) {
		// TODO Auto-generated method stub
		return o1.start - o2.start;
	}
}

class MeetingEndComparator implements Comparator<Meeting>{
	public int compare(Meeting o1, Meeting o2) {
		// TODO Auto-generated method stub
		return o1.end - o2.end;
	}
}
