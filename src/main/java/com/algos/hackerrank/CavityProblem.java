package com.algos.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by psekar on 1/8/15.
 */
public class CavityProblem {

    static class Cavity {
        int x;
        int y;
        public Cavity(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void findCavity(String[][] map) {


        // maintain an array to record which are cavities
        List cavityArr = new ArrayList<Cavity>();

        // do nothing for all corner cavities in map
        for (int i=0;i<map.length;i++) {
            for (int j = 0; j < map.length; j++) {
                if (i ==0 || i == map.length-1 || j==0 || j ==map.length-1) {
                    // do nothing
                } else {
                    if (new Integer(map[i-1][j]).intValue() < new Integer(map[i][j]).intValue() &&
                            new Integer(map[i+1][j]).intValue() < new Integer(map[i][j]).intValue() &&
                            new Integer(map[i][j-1]).intValue() < new Integer(map[i][j]).intValue()  &&
                                    new Integer(map[i][j+1]).intValue() < new Integer(map[i][j]).intValue()) {
                        //map[i][j] = "X";
                        cavityArr.add(new Cavity(i,j));
                    }
                }
            }
        }

        changeAndprintCavity(map, cavityArr);
    }
    public static void changeAndprintCavity(String[][] map, List<Cavity> arr){
        for (Cavity  c : arr) {
            map[c.x][c.y] = "X";
        }
        int x = map.length;
        for (int i=0;i<x;i++) {
            for (int j=0;j<x;j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String[][] cavityMap = new String[x][x];
        for (int i=0;i<x;i++) {
            String line = sc.next();
            for (int j=0;j< x;j++) {
                cavityMap[i][j] = String.valueOf(line.charAt(j));
            }

        }
        findCavity(cavityMap);
    }

}
