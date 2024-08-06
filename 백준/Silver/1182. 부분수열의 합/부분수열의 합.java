//package algorithm.brute_force;

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[] numbers;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        findSubsequence(0, new ArrayList<>(), s);

        System.out.print(count);
    }

    private static void findSubsequence(int start, List<Integer> subseq, int targetSum) {
        if (!subseq.isEmpty()) {
            int sum = calculateSum(subseq);
            if (sum == targetSum) {
                //System.out.println("sum = " + sum);
                //System.out.println("subseq : " + subseq);
                count++;
            }
        }

        for (int i = start; i < N; i++) {
            subseq.add(numbers[i]);
            findSubsequence(i + 1, subseq, targetSum);
            subseq.remove(subseq.size() - 1);
        }
    }

    private static int calculateSum(List<Integer> subseq) {
        int sum = 0;
        for (Integer i : subseq) {
            sum += i;
        }
        return sum;
    }
}
