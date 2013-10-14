package com.algos.sort;

import java.util.Scanner;

public class InsertSort2 {
	 public static void insertionSort(int[] ar){
         for (int j=1; j < ar.length-1; j++) {
             for (int i=0; i <= j; i++) {
                 if (ar[j] < ar[i]) {
                     int tmp = ar[i];
                     ar[i] = ar[j];
                     ar[j] = tmp;
                 }
printArray(ar);
             }
         }
     }


/* Tail starts here */
static void printArray(int[] ar) {
       for(int n: ar){
          System.out.print(n+" ");
       }
         System.out.println("");
    }
     
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int[] ar = new int[n];
         for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
         }
         insertionSort(ar);
     }
}
