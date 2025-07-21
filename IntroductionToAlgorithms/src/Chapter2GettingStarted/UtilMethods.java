package Chapter2GettingStarted;

import java.util.Arrays;

public class UtilMethods {

    public static void printArray(String s,int[] arr) {
        System.out.print(s + " ["); // Print the provided string first
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.print("]");
        System.out.println(); // Move to a new line for better formatting
    }
}
