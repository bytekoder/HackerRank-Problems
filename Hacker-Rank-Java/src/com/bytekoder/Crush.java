package com.bytekoder;

import java.util.*;

/**
 * Created by bshekhawat
 */
public class Crush {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<String> eachLine = new ArrayList<>();
        List<Long> emptyList = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            emptyList.add(0L);
        }

        while (count < m+1) {
            count++;
            String line = scanner.nextLine();

            if (!line.isEmpty()){
                eachLine.add(line);
            }
        }

        if (m == 0){
            System.out.println(0);
            System.exit(0);
        }

        for (String line : eachLine) {
            int[] arr = toArray(line, m);
            for (int j = arr[0]; j <= arr[1]; j++) {
                long curr = emptyList.get(j-1);
                emptyList.set(j - 1, curr + arr[2]);
            }
        }

        Collections.sort(emptyList);
        System.out.println(emptyList.get(n-1));
    }

    public static int[] toArray(final String line, final int len){
        int[] arr = new int[len];
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()){
            for (int i = 0; i < len; i++) {
                String token = tokenizer.nextToken();
                arr[i] = Integer.valueOf(token);
            }
        }
        return arr;
    }


}
