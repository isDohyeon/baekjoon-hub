//package algorithm.data_structure;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);

            if (index == '(') {
                stack.push(index);
            } else if (index == ')') {
                if (s.charAt(i - 1) == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}