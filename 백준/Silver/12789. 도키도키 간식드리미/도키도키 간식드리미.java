//package algorithm.datastructure;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() == index) {
                stack.pop();
                index++;
            }

            if (current == index) {
                index++;
            } else {
                stack.push(current);
            }
        }

        while (!stack.isEmpty() && stack.peek() == index) {
            stack.pop();
            index++;
        }
        String result = index == n+1 ? "Nice" : "Sad";
        System.out.print(result);
    }
}