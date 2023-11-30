package com.leetcode.problems;

/**
 * Leet Code - 367 - Easy - Find Valid Square
 * Hint - Binary Search
 */
public class PerfectSquare {

    public static void main(String[] args) {

        System.out.println(isPerfectSquare(888 * 888));

    }

    private static long isPerfectSquare(int num) {

        long l = 1;
        long r = num;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid == num) {
                return mid;
            }

            // using Math.abs in case there is a signed value
            if (Math.abs(mid * mid) > num)
                r = mid - 1;
            else
                l = mid + 1;

        }
        return -1;
    }

}
