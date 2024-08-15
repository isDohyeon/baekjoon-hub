//package algorithm.binary_search;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        long M = Long.parseLong(br.readLine());

        System.out.print(getMaxBudget(budgets, M));
    }

    private static long getMaxBudget(int[] budgets, long M) {
        int low = 0;
        int high = Arrays.stream(budgets).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) / 2;

            long budgetSum = 0;
            for (int budget : budgets) {
                budgetSum = budget < mid ? budgetSum + budget : budgetSum + mid;
            }

            if (budgetSum <= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}