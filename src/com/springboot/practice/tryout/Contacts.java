package com.springboot.practice.tryout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        List<String> contacts = new ArrayList<>(queries.length);
        List<Integer> searchIndex = new ArrayList<>();
        int length = queries.length;
        for (int i = 0; i < length; i++) {
            String operation = queries[i][0];
            String val = queries[i][1];
            if(operation.equalsIgnoreCase("add")){
                contacts.add(val);
            }else if(operation.equalsIgnoreCase("find")){
                searchIndex.add((int) contacts.parallelStream().filter(x -> x.startsWith(val)).count());
            }else {
                continue;
            }
        }
        return searchIndex.stream().mapToInt(Integer::intValue).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }
    class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap();
        public int size = 0; // this was the main trick to decrease runtime to pass tests.

        public void putChildIfAbsent(char ch) {
            children.putIfAbsent(ch, new TrieNode());
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void add(String str) {
            TrieNode curr = root;
            for (char ch : str.toCharArray()) {
                curr.putChildIfAbsent(ch);
                curr = curr.getChild(ch);
                curr.size++;
            }
        }

        public int find(String prefix) {
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                curr = curr.getChild(ch);
                if (curr == null) {
                    return 0;
                }
            }
            return curr.size;
        }
    }
}
