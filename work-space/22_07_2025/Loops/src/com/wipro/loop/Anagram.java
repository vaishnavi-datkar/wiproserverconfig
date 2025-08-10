package com.wipro.loop;

import java.util.Arrays;

public class Anagram{

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

               if (str1.length() !=str2.length()) {
            System.out.println("not anagrams");
        } else {
             char[] charArray1 =str1.toCharArray();
            char[] charArray2 =str2.toCharArray();

             Arrays.sort(charArray1);
            Arrays.sort(charArray2);    
            if (Arrays.equals(charArray1,charArray2)) {
                System.out.println("anagrams");
            } else {
                System.out.println("not anagrams");
            }
        }
    }
}
