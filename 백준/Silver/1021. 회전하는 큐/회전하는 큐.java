//package algorithm.data_structure;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int totalOperations = 0;

        for (int target : targets) {
            int index = 0;
            for (int num : deque) {
                if (num == target) {
                    break;
                }
                index++;
            }

            int leftShift = index;
            int rightShift = deque.size() - index;

            if (leftShift <= rightShift) {
                for (int i = 0; i < leftShift; i++) {
                    deque.addLast(deque.pollFirst());
                }
                totalOperations += leftShift;
            } else {
                for (int i = 0; i < rightShift; i++) {
                    deque.addFirst(deque.pollLast());
                }
                totalOperations += rightShift;
            }

            deque.pollFirst();
        }

        System.out.print(totalOperations);
    }
}