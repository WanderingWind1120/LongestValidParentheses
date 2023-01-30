package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        String s = "((((())))()";
        System.out.println(s.substring(0,2));
        String s1 = "((())())";
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(s1));
        System.out.println(solution.longestValidParentheses(s));
        System.out.println("Hello world!");
    }
}