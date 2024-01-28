package slidingWindow;

public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int K, int[] arr) {
        int windowSum = 0, windowStart = 0, result = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= K - 1) {
                result = Math.max(windowSum, result);
                windowSum -= arr[windowStart];
                windowStart++;
            }

        }
        return result;
    }


    public static void main(String[] args) {
        /*
        * Given an array of positive numbers and a positive number ‘k’,
        * find the maximum sum of any contiguous sub-array of size ‘k’.
        *
        * ex:
        * Input: [2, 1, 5, 1, 3, 2], k=3
        * Output: 9
        * Explanation: Sub-array with maximum sum is [5, 1, 3].
        */
        int result = MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5});
        System.out.printf("result equals: %s%n", result);
    }
}
