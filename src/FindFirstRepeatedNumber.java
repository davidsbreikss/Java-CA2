import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FindFirstRepeatedNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 0;
        while (true) {
            System.out.println("Enter the size of the array:");
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Invalid size. Please enter a positive number.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        System.out.println("Enter the elements of the array:");
        Integer repeatedNumber = findRepeatedNumber(size, scanner);

        if (repeatedNumber != null) {
            System.out.println("First repeated number is: " + repeatedNumber);
        } else {
            System.out.println("No repeated numbers found.");
        }

        scanner.close();
    }

    public static Integer findRepeatedNumber(int arraySize, Scanner scanner) {
        int[] arr = new int[arraySize];
        HashSet<Integer> numbers = new HashSet<>();

        for (int i = 0; i < arraySize; i++) {
            while (true) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    arr[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next();
                }
            }
        }
        for (int num : arr) {
            if (numbers.contains(num)) {
                return num;
            }
            numbers.add(num);
        }
        return null;
    }
}