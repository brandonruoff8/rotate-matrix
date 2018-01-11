import java.util.Scanner;

public class RotateMatrix {
	private int[][] matrix;
	private int rows;
	private int cols;
	
	public void readInMatrix(Scanner scan) {		
		rows = scan.nextInt();
		cols = rows;
		matrix = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		cloneTopLeft();		
	}
	
	public void printMatrix() {
		System.out.println("Current matrix: ");
		for(int i = 0; i < rows; i++) {
			System.out.print("|");
			for (int j = 0; j < cols; j++) {
				System.out.printf("%3d|", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public int[][] cloneTopLeft(){
		int halfBound = rows/2;
		int[][] tempq1 = new int[halfBound][halfBound];
		for(int i = 0; i < halfBound; i++) {
			for(int j = 0; j < halfBound; j++)
				tempq1[i][j] = matrix[i][j];
		}
		return tempq1;
	}
	
	public void rotateClockwise() {
		//clone q1 so it isn't lost in the process
		int[][] q1 = cloneTopLeft();	
		
		//move q4 to q1
		for(int i = rows/2; i < rows; i++) {
			for(int j = 0; j < cols/2; j++) {
				matrix[j][(rows - 1)%i] = matrix[i][j];
			}
		}
		
		//move q3 to q4
		for(int i = rows/2; i < rows; i++) {
			for(int j = cols/2 ; j < cols; j++) {
				matrix[j][(rows - 1)%i] = matrix[i][j];
			}
		}
		
		//move q2 to q3
		for(int i = 0; i < rows/2; i++) {
			for(int j = cols/2; j < cols; j++) {
				matrix[j][rows - 1 - i] = matrix[i][j];
			}
		}
		
		//move q1 to q2
		for(int i = 0; i < rows/2; i++) {
			for(int j = 0; j < cols/2; j++) {
				matrix[j][rows - 1 - i] = q1[i][j];
			}
		}
		System.out.println("Matrix rotated Clockwise! (:");
		
	}
	
	public void rotateCounterClockwise() {
		//clone q1 so it isn't lost in the process
		int[][] q1 = cloneTopLeft();	
		
		//move q2 to q1
		for(int i = 0; i < rows/2; i++) {
			for(int j = cols/2; j < cols; j++) {
				matrix[(cols - 1)%j][i] = matrix[i][j];
			}
		}
		
		//move q3 to q2
		for(int i = rows/2; i < rows; i++) {
			for(int j = cols/2 ; j < cols; j++) {
				matrix[(cols - 1)%j][i] = matrix[i][j];
			}
		}
		
		//move q4 to q3
		for(int i = rows/2; i < rows; i++) {
			for(int j = 0; j < cols/2; j++) {
				matrix[cols - 1 - j][i] = matrix[i][j];
			}
		}
		
		//move q1 to q4
		for(int i = 0; i < rows/2; i++) {
			for(int j = 0; j < cols/2; j++) {
				matrix[cols - 1 - j][i] = q1[i][j];
			}
		}
		System.out.println("Matrix rotated Counter-Clockwise! (:");
		
	}
}
