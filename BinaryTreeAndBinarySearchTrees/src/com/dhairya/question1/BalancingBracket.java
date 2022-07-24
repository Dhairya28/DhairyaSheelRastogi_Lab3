package com.dhairya.question1;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBracket {
    private static Scanner sc;
	private static boolean checkBracketsBalance(String bracketInput) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : bracketInput.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character d = (Character) (stack.pop());
                if ((c == '}' && d != '{') || (c == ')' && d != '(') || (c == ']' && d != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Enter Brackets String: ");
        String bracketInput = sc.next();
        if (checkBracketsBalance(bracketInput)) {
            System.out.println("The Entered String has balanced brackets");
        } else {
            System.out.println("The Entered Strings do not contain balanced brackets");
        }
    }
	
}
