package com.leetcode.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode#1838. Frequency of the Most Frequent Element
 * Find the number that occurs more than n/2.
 *
 * First Approach - Use Hashmap to count with streams.
 * Time Complexity - O(nlogn) for sorting + O(n) for one time traversal
 *
 * Second Approach - Use Hashmap and basic counter
 * Time Complexity - O(n)
 *
 * Third Approach - Boyer-Moore's Algorithm
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class NBy2FrequencyElementArray {

    public static void main(String[] args) {

        int[] inputArray = new int[] {1,3,5};

        //approach1(inputArray);
        /**
         * Moore's Algorithm -
         * 1. Traverse each element in the array
         * 2. Assign frequency for first element as 1, currVal is first element
         * 3. for i=0 ...Iterate over all elements and apply the following algo -
         *      3.a. If the next element is same as the previous one, frequency++
         *      3.b. If the next element is different, frequency--
         *      3.c. If the frequency == 0 , currVal is the element at index i
         */
        approachBoyerMooreAlgorithm(inputArray);


    }

    private static void approachBoyerMooreAlgorithm(int[] inputArray) {

        int frequency = 1;
        int currentValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {

            if(inputArray[i] != inputArray[i-1]){
                frequency--;
            }else{
                frequency++;
            }

            if(frequency == 0){
                currentValue = inputArray[i];
                frequency++;
            }

        }

        int potentialAns = currentValue;
        long count = IntStream.of(inputArray)
                        .filter(i -> i == potentialAns)
                                .count();

        if(count > inputArray.length/2){
            System.out.println(currentValue);
        }else{
            System.out.println(-1);
        }

    }

    private static void approach1(int[] inputArray) {
        Map<Integer,Long> frequencyMap = IntStream.of(inputArray)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()
                        ,Collectors.counting()));

        List<Map.Entry<Integer,Long>> sortedList = new ArrayList<>();
        sortedList.addAll(frequencyMap.entrySet());

        Collections.sort(sortedList, (o1, o2) -> {
            return o2.getValue().compareTo(o1.getValue());
        });

        Integer largestFrequency = sortedList.get(0).getKey();
        if(largestFrequency > inputArray.length / 2){
            System.out.println("Result - " + largestFrequency);
        }else{
            System.out.println("Result - " + -1);
        }
    }
}
