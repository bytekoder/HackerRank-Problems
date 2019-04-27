package com.bytekoder;


import java.util.Scanner;

/**
 * Created by bshekhawat
 */
public class CandyRobot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int total = n;
        int newCandies = 0;
        int[] c = new int[t];
        for (int c_i = 0; c_i < t; c_i++) {
            c[c_i] = in.nextInt();
        }
        // your code goes here

        // Remove the candies regardless since this is the first removal
        total = total - c[0];

        for (int i = 1; i < t; i++) {
            total = total - c[i];

            if (total < 5 && i != (t-1)) {
                int temp = n - total;
                total = total + temp;
                newCandies = newCandies + temp;
            }
        }

        System.out.println(newCandies);
    }
}
