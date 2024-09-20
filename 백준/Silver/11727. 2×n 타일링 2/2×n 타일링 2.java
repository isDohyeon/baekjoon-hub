//package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.print(getDp(N));
    }

    private static int getDp(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 3;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10_007;
        }


        return dp[N];
    }
}
