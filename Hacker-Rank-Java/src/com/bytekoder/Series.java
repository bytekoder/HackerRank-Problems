package com.bytekoder;

/**
 * Created by bshekhawat
 */

import java.util.*;

class Series {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            printSeries(a, b, n);
            System.out.println();
        }
        in.close();
    }

    private static void printSeries(int a, int b, int n) {

        int seed = 1;
        int firstTerm = a + (seed * b);
        int currentSum = firstTerm;

        if (a >= 0 && b <= 50){
            if (n == 1) {
                System.out.print(firstTerm);
            } else if (n > 1 && n < 16) {
                System.out.print(firstTerm);
                for (int i = 1; i < n; i++) {
                    seed = seed * 2;
                    int nextTerm = (seed * b);
                    currentSum = currentSum + nextTerm;

                    if (i < n -1){
                        System.out.print(currentSum + " ");
                    } else
                    {
                        System.out.print(currentSum);
                    }
                }
            }
        }
    }
}
