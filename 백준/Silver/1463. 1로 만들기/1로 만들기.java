//package algorithm.dynamic_programming;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(n));
    }

    private static int solution(int n) {
        // n이 1인 경우, 연산이 필요 없으므로 0 반환
        if (n == 1) {
            return 0;
        }

        // DP 배열 초기화
        int[] dp = new int[n + 1];
        dp[1] = 0;  // 1은 이미 1이므로 연산이 필요 없음

        // DP 배열 채우기
        for (int i = 2; i <= n; i++) {
            // 기본적으로 이전 수에서 1을 뺀 경우
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        // n을 1로 만드는 데 필요한 최소 연산 횟수 반환
        return dp[n];
    }
}
