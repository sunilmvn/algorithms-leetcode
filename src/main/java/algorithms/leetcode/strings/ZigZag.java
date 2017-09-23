package algorithms.leetcode.strings;

/** 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
 * like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Analysis - 
 * 0        6       12       18
 * 1     5  7    11 13    17 19
 * 2  4     8 10    14 16    20
 * 3        9       15       21
 * 
 * @author sumukkav
 *
 */
public class ZigZag {
	public String convert(String s, int numRows) {
		if(s == null || s.length() == 0){
			return "";
		}
		if(s.length() == 1 || numRows == 1){
			return s;
		}
        int rowLength = getLengthOfRow(s.length(), numRows);
        char[][] a = new char[numRows][rowLength];
        for(int i=0;i<numRows;i++){
        	for(int j=0;j<rowLength;j++){
        		a[i][j] = ' ';
        	}
        }
        int rowIndex = 0;
        int colIndex = 0;
        boolean isFullRow = true;
        for(int i=0;i<s.length();i++){
        	if(isFullRow){
        		System.out.println("Row is "+rowIndex+" and column is "+colIndex);
        		a[rowIndex][colIndex] = s.charAt(i);
        		rowIndex++;
        	}
        	else{
        		a[rowIndex][colIndex] = s.charAt(i);
        		rowIndex--;
        		colIndex++;
        	}
        	if(rowIndex == numRows){
        		rowIndex--;
        		rowIndex--;
        		colIndex++;
        		isFullRow = false;
        	}
        	if(rowIndex == 0){
        		isFullRow = true;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int m=0;m<numRows;m++){
        	for(int n=0;n<rowLength;n++){
        		if(a[m][n] != ' '){
        			sb.append(a[m][n]);
        		}
        	}
        }
        return sb.toString();
    }
	
	private int getLengthOfRow(int len, int numRows){
		int res = 0;
		boolean isFullRow = true;
		while(len > 0){
			if(isFullRow){
				res = res+1;
				len = len - numRows;
				System.out.println("res here "+res);
				System.out.println("len here "+len);
			}
			else{
				res = res + numRows - 2;
				len = len - (numRows - 2);
				System.out.println("res me here "+res);
				System.out.println("Len me here "+len);
			}
			isFullRow = !isFullRow;
		}
		System.out.println("No of columns is "+res);
		return res;
	}
	
	public static void main(String[] args){
		ZigZag zz = new ZigZag();
		System.out.println(zz.convert("PAYPALISHIRING", 6));
		//System.out.println(zz.convert("AB", 2));
	}

}
