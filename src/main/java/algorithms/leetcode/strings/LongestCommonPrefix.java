package algorithms.leetcode.strings;

public class LongestCommonPrefix {
	
	public String[] stringArray; 
	
	public String getLongestCommonPrefix(){

		String prefix="";
		
		int index = getMinimumStringLength();
		
		int low = 0;
		int high = index-1;
		
		while(low <= high){
			
			int mid = low + (high - low)/2;
			if(allStringsContainPrefix(low, mid)){
				
				prefix = prefix + stringArray[0].substring(low,mid+1);
				
				low = mid + 1;
				
			}
			else
				high = mid - 1;
		}
		
		return prefix;
	}
	
	
	private boolean allStringsContainPrefix(int start, int end){
		
		for(int i=0; i< stringArray.length; i++){
			for(int j=start; j<=end; j++){
				
				if(stringArray[i].charAt(j) != stringArray[0].charAt(j)){
					
					return false;
				}
			}
		}
		
		return true;
		
				
	}
	
	private int getMinimumStringLength(){
		
		int minLength = Integer.MAX_VALUE;
		
		for(String str: stringArray){
			
			if(str.length() < minLength)
				minLength = str.length();
		}
		
		return minLength;
		
	}

	
	public static void main(String[] args){
		
		
		//String[] strArray = {"skirmish", "skirt", "skirts", "skirolkar"};
		String[] strArray = {"answer","ansker","answher","ans","answert","answe"};
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		lcp.stringArray = strArray;
		String prefix = lcp.getLongestCommonPrefix();
		
		System.out.println("answer: "+ prefix);
		
	}
}
