import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixDiagonalSum {

    // https://github.com/davidsbreikss/Java-CA2

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        while (true) {
            System.out.println("Enter the size of the matrix:");
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Invalid size. Please enter a positive integer.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }

        diagonalSum(size);
        scanner.close();
    }

    public static void diagonalSum(int size) {
        int[][] arr = new int[size][size];
        int primarySum = 0;
        int secondarySum = 0;
        int num = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = num++;
                if (i == j) {
                    primarySum += arr[i][j];
                }
                if (i + j == size - 1) {
                    secondarySum += arr[i][j];
                }
            }
        }

        System.out.println("Matrix:");
        printMatrix(arr);
        System.out.println("Sum of primary diagonal of the matrix: " + primarySum);
        System.out.println("Sum of secondary diagonal of the matrix: " + secondarySum);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}