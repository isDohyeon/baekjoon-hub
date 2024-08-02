//package algorithm.datastructure;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        int current = 1;

        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number >= current) {
                while (number >= current) {
                    stack.push(current++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() == number) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    possible = false;
                    break;
                }
            }
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
