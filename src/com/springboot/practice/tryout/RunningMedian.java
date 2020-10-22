package com.springboot.practice.tryout;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            addToHeap(a[i]);
            result[i] = getMedian();
        }
    return result;


    }

    private static double getMedian() {
        if(maxHeap.isEmpty()){
            return 0;
        }else if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            return maxHeap.peek().doubleValue();
        }
    }

    private static void addToHeap(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
        }else if(maxHeap.size()==minHeap.size()){
            if(num < minHeap.peek()){
                maxHeap.add(num);

            }else{
                minHeap.add(num);
                maxHeap.add(minHeap.remove());
            }
        }else if(maxHeap.size()>minHeap.size()){
            if(num > maxHeap.peek()){
                minHeap.add(num);

            }else {
                maxHeap.add(num);
                minHeap.add(maxHeap.remove());
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.print(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();
    }
}
