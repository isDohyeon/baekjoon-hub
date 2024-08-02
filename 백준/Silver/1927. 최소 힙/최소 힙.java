//package algorithm.datastructure;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(getPqResult(minHeap)).append('\n');
            } else {
                minHeap.add(x);
            }
        }

        System.out.print(sb);
    }

    private static int getPqResult(PriorityQueue<Integer> minHeap) {
        return minHeap.isEmpty() ? 0 : minHeap.poll();
    }
}