package com.client.interview.questions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Print all Palindrome numbers in a range of numbers
 */
public class RangeOfPalindrome {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};

        int n = 1000;
        for (int i = 1; i < n; i++) {
            int sum = 0;

            int temp = i;
            while(temp > 0){

                sum = (sum * 10) + (temp % 10);
                temp = temp / 10;

            }

            if(sum == i){
                System.out.println(String.format(" %d is Palindrome",i));
            }

        }
    }

}
