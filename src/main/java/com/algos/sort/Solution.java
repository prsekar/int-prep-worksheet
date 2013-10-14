package com.algos.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String args[] ) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int s1sum=0,s2sum=0;
        for (int i=0;i<s1.length;i++){
             s1sum += s1[i];
             s2sum += s2[i];
        }
        if (s1sum == s2sum) {
        	System.out.println("Anagrams!");
        }
        else {
        	System.out.println("Not anagrams!");
        }
               
    }
}