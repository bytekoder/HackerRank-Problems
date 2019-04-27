package com.bytekoder;

/**
 * Created by bshekhawat
 */
public class MinimumMoves {

    public static void main(String[] args) {
        int[] A = {6, 4, 1, 7, 10};
        int count = 0;
        for (int i = 0; i < A.length -1; i++) {
            if (A[i] > A[i+1]){
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1] = temp;
                count++;
            }
        }
        System.out.println(count);
    }
}
