//package algorithm.brute_force;

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int S;
    private static int[] numbers;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        findSubsequence(0, 0);
        System.out.print(count);
    }

    private static void findSubsequence(int start, int currentSum) {
        if (start > 0 && currentSum == S) {
            count++;
        }

        for (int i = start; i < N; i++) {
            findSubsequence(i + 1, currentSum + numbers[i]);
        }
    }
}
