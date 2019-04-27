package com.bytekoder;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by bshekhawat
 */
public class Gakky {

    static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {//Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void main(String[] args) {
        isUniqueChars("asdasfewedf");
    }

    boolean oneEditAway(String first, String second) {
         /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

         /* Get shorter and longer string.*/
        String sl = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int indexl = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && indexl < sl.length()) {
            if (sl.charAt(indexl) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;
                if (sl.length() == s2.length()) {//On replace, move shorter pointer
                    indexl++;
                }
            } else {
                indexl++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;

    }

    void deleteDups(Node head) {
        Node current = head;
        while (current != null) {
             /* Remove all future nodes that have the same value */
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int inputVal) {
            val = inputVal;
            next = null;
        }
    }

    boolean deleteNode(Node node) {
        if (node == null || node.next == null){
            return false;
        }

        Node next = node.next;
        node.val = next.val;
        node.next = next.next;
        return true;
    }
}
