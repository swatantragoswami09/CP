package com.baba.BitManipulation;

import java.util.Scanner;

public class AllSubSetsOfString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        for (int i = 1; i < (1 << str.length()); i++) {
            filterSubString(i,str);
        }

    }

    public static void filterSubString(int n, String str) {
        int j = 0;
        String temp = "";
        while (n > 0) {
            if ((n & 1) == 1) {
                temp += str.charAt(j);
            }
            j++;
            n = n >> 1;
        }
        System.out.println(temp);
    }
}
