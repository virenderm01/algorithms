package com.springboot.practice;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {


    public static void main(String[] args) {
        List<String> in = new ArrayList<>();
        in.add("1");
        in.add("2");
        in.add("+");
        in.add("Z");
        System.out.println(totalScore(4,in));
    }

    public static int totalScore(int num, List<String> blocks)
    {
        // WRITE YOUR CODE HERE
        List<Integer> scores = new ArrayList<>(blocks.size());
        for (String str:
             blocks) {
            System.out.println(scores);
            if(str.matches("-?\\d+(\\.\\d+)?")){
                scores.add(Integer.parseInt(str));
                continue;
            }else if(str.equals("X")){
                if (scores.isEmpty()) {
                    scores.add(0);
                } else {
                    scores.add(2*scores.get(scores.size() - 1));
                }
            }else if(str.equals("Z")){
                if (scores.isEmpty()) {
                    continue;
                } else {
                    scores.remove(scores.get(scores.size() - 1));
                }
            }else if(str.equals("+")){
                if (scores.isEmpty()) {
                    scores.add(0);
                } else if(scores.size()<2){
                    scores.add(scores.get(scores.size() - 1));
                }else {
                    scores.add(scores.get(scores.size() - 1)+scores.get(scores.size()-2));
                }
            }

        }
        return scores.stream().mapToInt(Integer::intValue)
                .sum();
    }
}
