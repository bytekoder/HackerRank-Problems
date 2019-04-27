package com.bytekoder;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by bshekhawat
 */
public class PigLatin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // String input = scanner.nextLine();
        // translator(input);

        // Test cases
        translator("sandwich");
        translator("Stop");
        translator("No littering");

        // This test case is wrong in the document (shoes)
        translator("No shirts, no shoes, no service");

        translator("No persons under 14 admitted");
        translator("Hey buddy, get away from my car!");
    }

    private static String translator(String sentence) {

        boolean isVowelFound = false;
        boolean isPunctFound = false;
        StringBuilder builder = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        String prefix;
        String stem;
        char c = ' ';

        while (tokenizer.hasMoreTokens()) {

            String currentToken = tokenizer.nextToken();
            int length = currentToken.length();

            for (int i = 0; i < length; i++) {

                // If a word has no letters, don't translate
                if (currentToken.isEmpty() ) {
                    builder.append(currentToken).append(" ");
                }

                // Check for numbers
                if (StringUtils.isNumeric(currentToken)){
                    builder.append(currentToken).append(" ");
                    break;
                }

                // If length is 1
                if (currentToken.length() == 1) {
                    stem = currentToken.toUpperCase() + "yay";
                    builder.append(stem);
                }

                // Check for the first vowel
                if ((currentToken.charAt(i) == 'a' || currentToken.charAt(i) == 'e'
                        || currentToken.charAt(i) == 'i' || currentToken.charAt(i) == 'o'
                        || currentToken.charAt(i) == 'u' || currentToken.charAt(i) == 'y')
                        && isVowelFound == false && currentToken.length() > 1) {

                    isVowelFound = true;

                    // Check for punctuations
                    if (isPunctuation(currentToken.charAt(length - 1))) {
                        c = currentToken.charAt(length - 1);
                        isPunctFound = true;
                    }

                    prefix = currentToken.substring(0, i);
                    stem = currentToken.substring(i, length).replace(Character.toString(c), "");
                    String tempTranslate = stem + prefix + "ay";
                    builder.append(tempTranslate);

                    if (isPunctFound){
                        builder.append(c).append(" ");
                    } else {
                        builder.append(" ");
                    }
                }
            }

            // If it has all vowels
            if (currentToken.matches("[^aeiouyAEIOUY]")) {
                builder.append(currentToken).append("yay");
            }

            isVowelFound = false;
            isPunctFound = false;
        }
        String translated = builder.toString();

        // First letter capitalized, rest lower case
        if (!translated.trim().isEmpty()){
            translated = translated.substring(0, 1).toUpperCase() + translated.substring(1).toLowerCase();
        }
        System.out.println(translated);

        return translated;
    }

    public static boolean isPunctuation(char c) {
        return c == ','
                || c == '.'
                || c == '!'
                || c == '?'
                || c == ':'
                || c == ';'
                ;
    }

}
