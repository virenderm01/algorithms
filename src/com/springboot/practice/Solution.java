package com.springboot.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    public static int checkWinner(List<List<String>> codeList,
                           List<String> shoppingCart)
    {
        // WRITE YOUR CODE HERE
        LinkedList<String> codes = new LinkedList<>();
        for (List<String> code:
             codeList) {
            for (int i = 0; i <code.size() ; i++) {
                codes.push(code.get(i));

            }
            int gap = code.size();
            if(gap>shoppingCart.size()){
                return 0;
            }
            boolean combination = true;
            int pos =0;
            for (int i = 0; i <=shoppingCart.size()-gap ; i++) {
                combination = true;
                for (int j = i; j < i+gap; j++) {
                    if(codes.peekLast().equals("anything") || codes.peekLast().equals(shoppingCart.get(j))){
                        codes.pollLast();
                        pos = j;
                        if(codes.isEmpty()){
                            break;
                        }
                    }else {
                        combination = false;
                        break;
                    }
                }
                if(combination){

                    shoppingCart = shoppingCart.subList(pos+1, shoppingCart.size());
                    break;
                }

            }

        }
    return 1;

    }


    public static void main(String[] args) {
        List<String> codelist = new ArrayList<>();
        List<List<String>> finalList = new ArrayList<>();
        codelist.add("apple");
        codelist.add("apricot");
        List<String> codelist2 = new ArrayList<>();
        codelist2.add("banana");
        codelist2.add("anything");
        codelist2.add("guava");
        List<String> l3 = new ArrayList<>();
        l3.add("papaya");
        l3.add("anything");
        finalList.add(codelist);
        finalList.add(codelist2);
        finalList.add(l3);
        List<String> cart = new ArrayList<>();
        cart.add("banana");
        cart.add("orange");
        cart.add("guava");
        cart.add("apple");
        cart.add("apricot");

        cart.add("papaya");
        cart.add("kiwi");

        System.out.println(checkWinner(finalList,cart));


    }

}
