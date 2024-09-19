//package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(getNum(n)).append('\n');
        }

        System.out.print(sb);
    }

    private static long getNum(int n) {
        if (n <= 3) {
            return 1;
        }

        if (n <= 5) {
            return 2;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        return dp[n];
    }
}
