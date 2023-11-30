package com.leetcode.problems;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * LeetCode#76. Minimum Window Substring
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {


        String s = "ADOBECODEBANC";
        String t = "OCD";


        String output = minimumWindowSubstring(s, t);

        System.out.println("Minimum window SubString - \t" + output);
    }

    private static String minimumWindowSubstring(String s, String t) {

        //count target string
        Map<Character, Long> countTarget = countOccurences(t);
        // logic

        int lp = 0;
        int rp = lp + 1;

        int minLength = Integer.MAX_VALUE;
        String minWindowSubstring = "";

        for (int i = 0; i < s.length() - 1; i++) {

            String currentSubstring = s.substring(lp, rp + 1);
            Map<Character, Long> countSubstring = countOccurences(currentSubstring);


            while (mapAreEqual(countSubstring, countTarget)) {

                if (rp - lp < minLength) {
                    minWindowSubstring = s.substring(lp, rp + 1);
                }

                minLength = Math.min(minLength, rp - lp);

                // if find a match, minimize the window
                lp++;
                currentSubstring = s.substring(lp, rp + 1);
                countSubstring = countOccurences(currentSubstring);
            }

            // if we did not find the string maximize the window
            rp++;


        }

        return minWindowSubstring;
    }

    private static boolean mapAreEqual(Map<Character, Long> countSubstring, Map<Character, Long> countTarget) {
        return countTarget.entrySet().stream()
                .allMatch(e -> e.getValue() <= countSubstring.getOrDefault(e.getKey(), 0l));
    }

    private static Map<Character, Long> countOccurences(String t) {

        return t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Function.identity(),Collectors.counting()
    }

}
