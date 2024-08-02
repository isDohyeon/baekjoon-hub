//package algorithm.data_structure;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> absHeap = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return Integer.compare(o1, o2);
            } else {
                return Integer.compare(abs1, abs2);
            }
        });

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                absHeap.add(x);
            } else {
                if (absHeap.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(absHeap.poll()).append('\n');
                }
            }
        }

        System.out.print(sb);
    }

}