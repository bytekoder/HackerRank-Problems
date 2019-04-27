package com.bytekoder;

import java.util.*;

/**
 * Created by bshekhawat
 */
public class LargestSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int length = scanner.nextInt();
        findLargestAndSmallest(S, length);
    }

    private static void findLargestAndSmallest(String a, int length) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < a.length() - (length - 1); i++) {
            list.add(a.substring(i, i + 3));
        }
        Collections.sort(list);

        System.out.println(list.get(0));
        System.out.println(list.get(list.size() - 1));
    }

}
