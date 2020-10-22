package com.springboot.practice.tryout;

import java.util.HashSet;

public class TripletSum {

    public static void main(String[] args) {
        int [] arr = {-1, 2, 3, 4, 5, 2, 1};
        int sum = 0;
        findTriplets(arr, sum);
    }

    private static void findTriplets(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        boolean found = false;
        for(int i =0; i<arr.length-1; i++){

            set.add(i);
            for(int j=i+1; i<arr.length; j++){
                int tmp = -(arr[j]+ arr[i]);
                if(set.contains(tmp)){
                    System.out.printf("%d %d %d\n", tmp, arr[i], arr[j]);
                    found = true;
                }else {
                    set.add(arr[j]);
                }
            }
        }
        if(!found){
            System.out.printf("No Triplets Found\n");
        }
    }
}
