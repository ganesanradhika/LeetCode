package com.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode#2301. Match Substring After Replacement
 */
public class MatchSubstringAfterReplacement {

    public static void main(String... args){
        String s = "Foo5eetbaR", sub = "leetd";
        char[][] mapp = {{'e','3'},{'t','7'},{'t','8'},{'d','b'},{'p','b'},{'l','5'}};
        boolean bool = matchReplacement(s, sub, mapp);
        System.out.println("Bool value - " + bool);

    }

    private static boolean matchReplacement(String s, String sub, char[][] mapp) {

        Map<Character, Set<Character>> map = new HashMap<>();

        for (char[] charMap:mapp) {
            map.putIfAbsent(charMap[0],new HashSet<>());
            map.get(charMap[0]).add(charMap[1]);
        }


        for (int i = 0; i <= s.length()-sub.length(); i++) {
            boolean found = true;
            for (int j = i, k=0; k < sub.length(); k++) {

                if(s.charAt(j+k) == sub.charAt(k)){
                    continue;
                }

                if((map.containsKey(sub.charAt(k))
                        && map.get(sub.charAt(k)).contains(s.charAt(j+k)))){
                    continue;
                }

                if(!(map.containsKey(sub.charAt(k))
                        && map.get(sub.charAt(k)).contains(s.charAt(j)))){
                    found = false;
                    break;
                }

            }
            if(found)
                return true;
        }
        return false;
    }
}
