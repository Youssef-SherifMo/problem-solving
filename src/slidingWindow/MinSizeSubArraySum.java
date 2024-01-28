package slidingWindow;

import java.util.Arrays;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int K, int[] arr) {
        int windowSum=0,windowStart=0,minLength=Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum+=arr[windowEnd];

            while (windowSum>= K){
                minLength = Math.min(minLength,windowEnd-windowStart+1);
                windowSum-=arr[windowStart];
                windowStart++;
            }

        }
        return minLength== Integer.MAX_VALUE? 0:minLength;
    }


    public static void main(String[] args) {
        /*
        * Given an array of positive numbers and a positive number ‘K’,
        * find the length of the smallest contiguous sub-array
        * whose sum is greater than or equal to ‘K’.
        * Return 0, if no such sub-array exists.
        * Ex:
        * ----------------------------------
        * Input:[2, 1, 5, 2, 3, 2], k=7
        * Output: 2
        * Explanation: The smallest sub-array with a sum greater than or equal to '7' is [5, 2].
        */
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.printf("result equals: %s%n", result);
        result=MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.printf("result equals: %s%n", result);
        result=MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.printf("result equals: %s%n", result);
    }
}

