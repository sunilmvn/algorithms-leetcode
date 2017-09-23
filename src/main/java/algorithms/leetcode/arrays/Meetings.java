package algorithms.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.leetcode.datastructures.Meeting;
import algorithms.leetcode.datastructures.Stack;

/**
 * Given a list of meetings (with start and end times) and a single meeting room,
 * schedule non-overlapping meetings in the room to have maximum no of meetings 
 * @author sumukkav
 *
 */
public class Meetings {
	Map<Meeting, Stack<Meeting>> map = new HashMap<Meeting, Stack<Meeting>>();
	private int getNextMeetingIndex(int currentIndex, List<Meeting> mList){
		Meeting m = mList.get(currentIndex);
		int nextIndex = currentIndex+1;
		while(nextIndex<mList.size()){
			Meeting next = mList.get(nextIndex);
			if(next.start>=m.end){
				return nextIndex;
			}
			nextIndex++;
		}
		return -1;
	}
	
    //Get the meeting Lists for all meetings from current to next in time
	//{1,5}{3,4}{4,6}{5,8}....
	public Stack<Meeting> getMeetings(List<Meeting> meetingList){
		//Sort the meetings with start time
		return getMeetingList(meetingList, 0);
	}
	
	private Stack<Meeting> getMeetingList(List<Meeting> mList, int index){
		Meeting thisMeeting = mList.get(index);
		System.out.println("In getMeetingsList for meeting "+thisMeeting.start+" "+thisMeeting.end);
		
		if(map.containsKey(thisMeeting)){
			return map.get(thisMeeting);
		}
		if(index == mList.size()-1){
			Stack<Meeting> s = new Stack<Meeting>();
			s.push(thisMeeting);
			map.put(thisMeeting, s);
			return s;
		}
		int curr = index+1;
		Meeting maxMeeting = null;
		int max = 0;
		int nextMeetingIndex = getNextMeetingIndex(index, mList);
		//System.out.println("Next Meeting Index "+nextMeetingIndex);
		if(nextMeetingIndex != -1){
			while(curr < nextMeetingIndex){
				Stack<Meeting> currStack = getMeetingList(mList, curr);
				System.out.println(currStack);
				if(currStack.getCount() > max){
					max = currStack.getCount();
					maxMeeting = mList.get(curr);
				}
				curr++;
			}
			Stack<Meeting> nextMeetingStack = getMeetingList(mList, nextMeetingIndex);
			if(nextMeetingStack.getCount()+1 > max){
				Stack<Meeting> currMeetingStack = 
						copyMeetingStack(nextMeetingStack, thisMeeting);
				map.put(thisMeeting, currMeetingStack);
			}
			else{
				map.put(thisMeeting, map.get(maxMeeting));
			}
		}
		else{
			while(curr < mList.size()){
				Stack<Meeting> currStack = getMeetingList(mList, curr);
				if(currStack.getCount() > max){
					max = currStack.getCount();
					maxMeeting = mList.get(curr);
				}
				curr++;
			}
			map.put(thisMeeting, map.get(maxMeeting));
		}
		return map.get(thisMeeting);
	}
	
	private Stack<Meeting> copyMeetingStack(Stack<Meeting> curr, Meeting m){
		Stack<Meeting> s = new Stack<Meeting>();
		Stack<Meeting> s1 = new Stack<Meeting>();
		while(curr.peek() != null){
			s.push(curr.pop());
		}
		while(s.peek() != null){
			s1.push(s.pop());
		}
		s1.push(m);
		return s1;
	}
	
	public static void main(String[] args){
		Meetings meet = new Meetings();
		List<Meeting> list = new ArrayList<Meeting>();
		list.add(new Meeting(1,3));
		list.add(new Meeting(2,4));
		list.add(new Meeting(3,5));
		list.add(new Meeting(4,7));
		list.add(new Meeting(6,10));
		list.add(new Meeting(8,11));
		list.add(new Meeting(9,11));
		Stack<Meeting> result = meet.getMeetings(list);
		System.out.println(result.getCount());
		System.out.println(result);
	}
}
