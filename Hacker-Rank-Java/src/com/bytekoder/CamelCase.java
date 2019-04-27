package com.bytekoder;

import java.util.Scanner;

/**
 * Created by bshekhawat
 */
public class CamelCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int count = 0;

        if (s != null){
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if ((int) arr[i] >= 65 && (int) arr[i] <= 90 ){
                    count++;
                }
            }
        }
        System.out.println(count + 1);
    }
}
