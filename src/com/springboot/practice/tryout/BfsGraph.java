package com.springboot.practice.tryout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BfsGraph {


    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int i=0; i<testCases; i++){
            int vertices = scan.nextInt();
            int edges = scan.nextInt();
            ArrayList<Integer>[] edgeList = new ArrayList[vertices];
            for (int k = 0; k <vertices ; k++) {
                edgeList[k]=new ArrayList<>();
            }
            for(int j=0; j<edges; j++){
                int source = scan.nextInt()-1;
                int dest = scan.nextInt()-1;
                ArrayList tmp = edgeList[source];
                tmp.add(dest);
                tmp = edgeList[dest];
                tmp.add(source);

            }
            int start = scan.nextInt();
            List<Integer> result = bfs(edgeList,start);
            for (int x=0; x<result.size();x++ ) {
                if(x!=start-1){
                    if(result.get(x)==0){
                        System.out.print("-1");
                    }else {
                        System.out.print(result.get(x));
                    }
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static List<Integer> bfs(ArrayList<Integer>[] edgeList, int start) {
        int [] result = new int[edgeList.length];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start-1);
        while (!queue.isEmpty()){
            int current = queue.pollLast();
            List<Integer> tmp = edgeList[current];
            for (int i = 0; i <tmp.size() ; i++) {
                int vert = tmp.get(i);
                if(result[vert]==0){
                    queue.addFirst(tmp.get(i));
                    result[vert] = result[current] + 6;
                }

            }
        }



        return  IntStream.of(result).boxed().collect(Collectors.toList());
    }
}
