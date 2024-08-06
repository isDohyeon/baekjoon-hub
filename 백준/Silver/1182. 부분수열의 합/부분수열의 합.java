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

        findSubsequence(0, new ArrayList<>());

        System.out.print(count);
    }

    private static void findSubsequence(int start, List<Integer> subsequence) {
        if (!subsequence.isEmpty() && calculateSum(subsequence) == S) {
            count++;
        }

        for (int i = start; i < N; i++) {
            subsequence.add(numbers[i]);
            findSubsequence(i + 1, subsequence);
            subsequence.remove(subsequence.size() - 1);
        }
    }

    private static int calculateSum(List<Integer> subsequence) {
        int sum = 0;
        for (Integer i : subsequence) {
            sum += i;
        }
        return sum;
    }
}
