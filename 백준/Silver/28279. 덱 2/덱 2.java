//package algorithm.datastructure;

import java.util.*;
import java.io.*;

public class Main {

    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] parts = input.split(" ");

            switch (parts[0]) {
                case "1":
                    deque.offerFirst(Integer.parseInt(parts[1]));
                    break;
                case "2":
                    deque.offerLast(Integer.parseInt(parts[1]));
                    break;
                default:
                    sb.append(getOrderResult(parts[0])).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }

    private static int getOrderResult(String input) {
        switch (input) {
            case "3":
                return deque.isEmpty() ? -1 : deque.pollFirst();
            case "4":
                return deque.isEmpty() ? -1 : deque.pollLast();
            case "5":
                return deque.size();
            case "6":
                return deque.isEmpty() ? 1 : 0;
            case "7":
                return deque.isEmpty() ? -1 : deque.peekFirst();
            case "8":
                return deque.isEmpty() ? -1 : deque.peekLast();
            default:
                return -1;
        }
    }
}
