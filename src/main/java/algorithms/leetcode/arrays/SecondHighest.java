package algorithms.leetcode.arrays;

/**
 *
A "run" of values in a list is defined to be a sequence of
one or more consecutive values that are the same. For
example, for ['a', 'b', 'b', 'b', 'c', 'c', 'b'], the runs
are:
'a'            <--- length 1
'b', 'b', 'b'  <--- length 3   (longest run)
'c', 'c'       <--- length 2   (2nd longest run)
'b'            <--- length 1

 * @author sumukkav
 *
 */
public class SecondHighest {
	
	// Returns the length of the second-longest run in the array "values"
	public int length_of_second_longest_run(String []values) {
		if(values.length == 0)
			return 0;
		int i =1;
		String last = values[0];
		int longest = 1;
		int second = 0;
		int curr = 1;
		while(i<values.length){
			if(values[i].equals(last)){
				curr++;
			}
			else{
				if(longest < curr){
					second = longest;
					longest = curr;
				}
				else if(second<curr){
					second = curr;
				}
				last = values[i];
				curr = 1;
			}
			i++;
		}
		if(longest < curr){
			second = longest;
			longest = curr;
		}
		else if(second<curr){
			second = curr;
		}
		return second;
	}

	public static void main(String[] args) {
		String[] values = {"a", "b", "b", "b", "b", "c", "c", "c", "b"};
		SecondHighest sec = new SecondHighest();
		System.out.println("Second Highest is: "+sec.length_of_second_longest_run(values));
	}

}
