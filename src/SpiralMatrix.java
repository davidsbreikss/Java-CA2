import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

    // https://github.com/davidsbreikss/Java-CA2

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 0, columns = 0;

        while (true) {
            System.out.println("Enter rows and columns of the matrix separated by space (positive integers):");
            try {
                rows = scanner.nextInt();
                columns = scanner.nextInt();
                if (rows <= 0 || columns <= 0) {
                    System.out.println("Rows and columns must be positive integers. Try again.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter two positive integers.");
                scanner.next();
            }
        }

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the elements of the matrix row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                while (true) {
                    try {
                        matrix[i][j] = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer:");
                        scanner.next();
                    }
                }
            }
        }

        getSpiral(matrix);

        scanner.close();
    }

    public static void getSpiral(int[][] matrix) {
        List<Integer> traversedMatrix = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                traversedMatrix.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                traversedMatrix.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    traversedMatrix.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    traversedMatrix.add(matrix[i][left]);
                }
                left++;
            }
        }
        System.out.println("Result of traversed matrix is: " + traversedMatrix);
    }
}