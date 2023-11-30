package com.leetcode.problems;

public class MaxiumSumSubarray {

    public static void main(String[] args) {
        int[] input = new int[] {1,-1,3,-5,6,4,-1,2};

        /**
         * Using Kadane's Algorithm.
         * TC - O(n)
         * Algo -
         * 1. Iterate over each element of the array. Keep a maxSum variable and currentSum variable
         * 2. Keeping summing (like sliding window) and store is in currentSum
         * 3. After each iteration - maxSum = Math.max(maxSum, currentSum);
         * 4. If sum < 0 - ignore the previous window and set currentSum = 0
         *
         */
        int maxSum = maxSumSubArray(input);
        System.out.println("Maximum Sum :\t" + maxSum);

    }

    private static int maxSumSubArray(int[] input) {

        int currentSum = -1;
        int maxSubArraySum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if(currentSum < 0){
                currentSum = 0;
                startIndex = i;
            }
            currentSum += input[i];
            if(maxSubArraySum < currentSum){
                endIndex = i;
            }
            maxSubArraySum = Math.max(maxSubArraySum,currentSum);
        }
        System.out.println("startIndex - " + startIndex+" , endIndex - " + endIndex);
        return maxSubArraySum;
    }

}
