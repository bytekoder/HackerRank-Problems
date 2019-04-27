package com.bytekoder;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by bshekhawat
 */
public class MelodiousPassword {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        char[] vowels = {'a', 'e', 'i', 'o', 'u',};
        Set<String> passwords = new HashSet<>();
        StringBuffer buffer = new StringBuffer();

        if (n == 1) {
            for (int j = 98; j < 123; j++) {
                if (j != 121) {
                    buffer.append((char) j);
                    passwords.add(buffer.toString());
                    buffer.setLength(0);
                }
            }
        }

        if (n > 1) {
            for (int i = 0; i < vowels.length; i++) {
                for (int j = 97; j < 123; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j != 121 && j != 97 && j != 101 && j != 105 && j != 111 && j != 117) {
                            buffer.append((char) j);
                        }
                        buffer.append(vowels[i]);
                    }

                    passwords.add(buffer.toString());
                    passwords.add(buffer.reverse().toString());
                    buffer.setLength(0);
                }

            }

        }
        for (String password : passwords) {
            System.out.println(password);
        }

        System.out.println("Total " + passwords.size());
    }

}

