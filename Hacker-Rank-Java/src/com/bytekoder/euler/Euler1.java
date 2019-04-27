package com.bytekoder.euler;

import java.util.Scanner;

/**
 * Created by bshekhawat
 */
public class Euler1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arr = new int[t];
        int count = 0;

        while (t < 1 && t > 100000) {
            for (int a = 0; a < t; a++) {
                while (in.nextInt() < 1 && in.nextInt() > 1000000000) {
                    int n = in.nextInt();
                    if (n != 0) {
                        arr[a] = n;
                    }
                }

            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 3; j < arr[i]; j++) {
                if (j % 3 == 0 || j % 5 == 0) {
                    count = count + j;
                }
            }
            System.out.println(count);
            count = 0;
        }

    }
}
