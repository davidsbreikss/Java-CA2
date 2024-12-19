import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        while (true) {
            System.out.println("Initialize the size of the table (positive integer only):");
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

        int[][] table = generateTable(size);
        printTable(table);

        scanner.close();
    }

    public static int[][] generateTable(int arrSize) {
        int[][] table = new int[arrSize][arrSize];
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    public static void printTable(int[][] table) {
        for (int[] row : table) {
            System.out.println(Arrays.toString(row));
        }
    }
}