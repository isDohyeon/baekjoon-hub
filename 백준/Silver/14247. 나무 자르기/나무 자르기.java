//package algorithm.greedy;

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[] heights;
    private static int[] grow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        heights = new int[N];
        grow = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(getMaxQuantity());
    }

    private static long getMaxQuantity() {
        Arrays.sort(grow);

        long maxQuantity = 0;

        for (int i = 0; i < N; i++) {
            maxQuantity += heights[i] + (long) grow[i] * i;
        }

        return maxQuantity;
    }
}
