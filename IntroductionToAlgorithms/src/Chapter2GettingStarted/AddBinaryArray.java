package Chapter2GettingStarted;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AddBinaryArray {

    public static int [] binaryArray(int [] a, int [] b){
        int maxLength = Math.max(a.length, b.length);
        int [] result = new int [maxLength+1];
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int bitA = getBitFromEnd(a, i);
            int bitB = getBitFromEnd(b, i);
            int sum = bitA + bitB +carry;
            result[maxLength-i] = sum%2;
            carry = sum/2;
        }

        result[0] = carry;
        // If no carry, return n-sized array
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }

    private static int getBitFromEnd(int[] arr, int i) {
        int index = arr.length - 1 - i;
        return index >= 0 ? arr[index] : 0;
    }

    public static void main(String[] args) {
        int []a = {1, 0, 1};        // 5
        int [] b = {1, 1, 1, 1};     // 15
        int[] c = binaryArray(a, b);
        Arrays.stream(c).forEach(i -> System.out.print(i+ " "));

    }

}
