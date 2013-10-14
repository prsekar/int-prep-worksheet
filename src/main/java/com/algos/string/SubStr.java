package com.algos.string;

import java.util.Scanner;

public class SubStr {
    
    public static void countSubstr(char[] s) {
        int count=0;
        for (int i=0;i< s.length;i++) {
        	int s1=0;
            for (int j = i;j < s.length; j++) {
            	if (s[s1] == s[j]) {
            		count++;
            	}
            	else {
            		break;
            	}
            	s1++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i< t;i++) {
            String s1 = sc.next();
            countSubstr(s1.toCharArray());
        }
         
    }
}