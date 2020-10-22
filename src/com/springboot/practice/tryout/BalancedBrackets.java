package com.springboot.practice.tryout;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> balance = new Stack<>();
        boolean valid = true;
        for (Character c:
             s.toCharArray()) {
            if(!valid){
                break;
            }
            if(c.equals('(')||c.equals('[')||c.equals('{')){
                balance.push(c);
            }else if((c.equals(')')||c.equals(']')||c.equals('}')) && !balance.isEmpty()){
                switch (c){
                    case ')':
                        if(!balance.pop().equals('(')){
                            valid=false;
                        };
                        break;
                    case ']':
                        if(!balance.pop().equals('[')){
                            valid=false;
                        }
                        break;
                    case '}':
                        if(!balance.pop().equals('{')){
                            valid=false;
                        }
                        break;

                }
            }else{
                valid=false;
            }

        }
        return balance.isEmpty()&&valid?"YES":"NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);
        }


        scanner.close();
    }

}
