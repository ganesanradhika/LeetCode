package com.client.interview.questions;

import java.util.*;

public class HashMapSorter {

    public static void main(String[] args){
        Map<String,Integer> votingResults = new HashMap<>();
        votingResults.put("Sarah",5);
        votingResults.put("james",15);
        votingResults.put("deepak",10);

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(votingResults.entrySet());
        Collections.sort(   sortedList,
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });


        sortedList.stream().map(e -> e.getKey()).forEach(e -> System.out.println(e));



    }

}
