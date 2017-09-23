package algorithms.leetcode.arrays;


/** 48. Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * @author sumukkav
 *
 */
public class RotateImage {
	
	public void rotate(int[][] matrix) {
		int rowl = matrix.length;
		int columnl = matrix[0].length;
		if(rowl != columnl){
			return;
		}
		for(int i=0;i<matrix.length/2;i++){
			int uptocolumn = matrix[i].length-1-i-1;
			for(int j=i;j<=uptocolumn;j++){
				int temp = matrix[rowl-1-j][i];
				matrix[rowl-1-j][i] = matrix[rowl-1-i][rowl-1-j];
				matrix[rowl-1-i][rowl-1-j] = matrix[j][rowl-1-i];
				matrix[j][rowl-1-i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
    }
	
	public void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		RotateImage ri = new RotateImage();
		//int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = {{1,2},{3,4}};
		ri.printMatrix(matrix);
		ri.rotate(matrix);
		System.out.println("After Rotating - ");
		ri.printMatrix(matrix);
	}
}
