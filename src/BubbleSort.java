import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BubbleSort {

    // https://github.com/davidsbreikss/Java-CA2

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        while (true) {
            System.out.println("Enter the size of the array:");
            try {
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Please enter a positive integer.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a number, please enter a valid integer.");
                scanner.next();
            }
        }

        int[] array = new int[size];
        System.out.println("Enter " + size + " elements of the array:");

        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    array[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Not a number, please enter a valid integer.");
                    scanner.next();
                }
            }
        }

        System.out.println("Array before sorting: " + Arrays.toString(array));

        int swapCount = bubbleSort(array);

        System.out.println("Array after sorting: " + Arrays.toString(array));
        System.out.println("Total number of swaps performed: " + swapCount);
    }

    public static int bubbleSort(int[] array) {
        int swapCount = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
}