package com.example.challenges;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class MinDeletions {
    private Map<String,Integer> frequency;

    /**
     * Given a string s of size n compute the amount of deletions in O(N) time so that
     * no two different characters in s appears in the string at the same frequency.
     * @param s
     * @return deletions
     */
    public int minDeletions(String s) {
        this.frequency = new HashMap<String,Integer>();
        Set<Integer> used = new HashSet();
        int deletions = 0;
        s.chars().mapToObj(c -> (char)c).forEach(character -> {
            this.frequency.putIfAbsent(character.toString(),0);
            this.frequency.computeIfPresent(character.toString(), (c,v) -> v+1 );
        });

        for(Integer v : this.frequency.values()){
            while(v > 0 && !used.add(v)){
                v--;
                deletions++;
            }
        }
        return deletions;
    }
}
