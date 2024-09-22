//package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.print(getMinSquareSum(N));
    }

    private static int getMinSquareSum(int N) {
        if (isPerfectSquare(N)) {
            return 1;
        }

        for (int i = 1; i * i <= N; i++) {
            if (isPerfectSquare(N - i * i)) {
                return 2;
            }
        }

        for (int i = 1; i <= i * i; i++) {
            for (int j = 1; j * j <= N - i * i; j++) {
                if (isPerfectSquare(N - i * i - j * j)) {
                    return 3;
                }
            }
        }

        return 4;
    }

    private static boolean isPerfectSquare(int N) {
        int sqrt = (int) Math.sqrt(N);
        return sqrt * sqrt == N;
    }
}
