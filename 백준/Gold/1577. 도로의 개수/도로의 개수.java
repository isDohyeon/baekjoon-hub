//package algorithm.dynamic_programming;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;

    private static long[][] dp;
    private static boolean[][] horizon;
    private static boolean[][] vertical;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][M + 1];
        horizon = new boolean[N + 1][M + 1];
        vertical = new boolean[N + 1][M + 1];

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            markBolcked(a, c, b, d);
        }

        System.out.print(getPathCount());
    }

    private static long getPathCount() {
        dp[0][0] = 1;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (j > 0) {
                    if (!horizon[i][j]) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }

                if (i > 0) {
                    if (!vertical[i][j]) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
        }

        return dp[N][M];
    }

    private static void markBolcked(int a, int c, int b, int d) {
        if (a == c) {
            if (b < d) {
                horizon[a][d] = true;
            } else {
                horizon[a][b] = true;
            }
        } else {
            if (a < c) {
                vertical[c][b] = true;
            } else {
                vertical[a][b] = true;
            }
        }
    }
}
