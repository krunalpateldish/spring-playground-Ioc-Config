package com.example;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by trainer2 on 5/15/17.
 */

@Component
public class WordCounter {


        public HashMap<String, Integer> count (String input){

                String res = input.replaceAll("[\\[()\\]{}+\\\\\\/-]", " ").replaceAll(" +", " ");
                String inputString = res;
                String[] splitted = inputString.split(" ");
                HashMap counterHashMap = new HashMap();
                int x;

                for (int i = 0; i < splitted.length; i++) {
                    if (!counterHashMap.containsKey(splitted[i])) {
                        counterHashMap.put(splitted[i], 1);
                    } else {
                        counterHashMap.put(splitted[i], (Integer) counterHashMap.get(splitted[i]) + 1);
                    }
                }
                return (HashMap<String, Integer>) counterHashMap;

            }

}