//package algorithm.greedy;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int K;

    private static int[] tall;
    private static int[] gap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tall = new int[N];
        gap = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tall[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                gap[i - 1] = tall[i] - tall[i - 1];
            }
        }

        System.out.print(getMaxCost());
    }

    private static int getMaxCost() {
        int cost = 0;

        Arrays.sort(gap);

        for (int i = 0; i <= N - K; i++) {
            cost += gap[i];
        }

        return cost;
    }
}