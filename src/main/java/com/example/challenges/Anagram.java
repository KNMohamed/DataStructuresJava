package com.example.challenges;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String one = "restful";
        String two = "fluster";

        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram(one,two));
    }

    public boolean isAnagram(String s1, String s2){
        if(s1.length() == s2.length()){
            char [] s1Char = s1.toCharArray();
            char [] s2Char = s2.toCharArray();
            Arrays.sort(s1Char);
            Arrays.sort(s2Char);

            for(int i = 0; i < s1Char.length; i ++){
                if(s1Char[i] != s2Char[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
