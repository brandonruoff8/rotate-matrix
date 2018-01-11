import java.util.Scanner;
import java.io.*;

public class MatrixRotationTester {

	public static void main(String[] args) {
		
		try {
			Scanner scan = new Scanner(new File("input.txt"));
			RotateMatrix rotateMatrix = new RotateMatrix();
			rotateMatrix.readInMatrix(scan);
			rotateMatrix.printMatrix();
			//rotateMatrix.rotateClockwise();
			rotateMatrix.rotateCounterClockwise();
			rotateMatrix.printMatrix();
		}
		catch(Exception e) {
			System.out.print("Run-time error occured.");
		}
	}
}
