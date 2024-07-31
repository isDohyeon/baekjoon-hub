//package algorithm.datastructure;

import java.util.*;
import java.io.*;

public class Main {

    private static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("push")) {
                queue.offer(Integer.parseInt(input[1]));
            } else {
                String order = input[0];
                sb.append(getOrderResult(order)).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int getOrderResult(String order) {
        switch (order) {
            case "pop":
                return queue.isEmpty() ? -1 : queue.pollFirst();
            case "size":
                return queue.size();
            case "empty":
                return queue.isEmpty() ? 1 : 0;
            case "front":
                return queue.isEmpty() ? -1 : queue.peekFirst();
            case "back":
                return queue.isEmpty() ? -1 : queue.peekLast();
            default:
                return -1; 
        }
    }
}
