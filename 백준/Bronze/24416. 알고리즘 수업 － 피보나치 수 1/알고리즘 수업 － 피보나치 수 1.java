//package algorithm.dynamic_programming;

import java.io.*;

public class Main {

    private static int fibCount = 0;
    private static int fibonacciCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);

        System.out.print(fibCount + " " + fibonacciCount);
    }

    private static long fib(int n) {
        if (n == 1 || n == 2) {
            fibCount += 1;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static long fibonacci(int n) {
        if (n == 1) {
            return 1;
        }

        long[] fibo = new long[n + 1];
        fibo[1] = 1;
        fibo[2] = 1;

        for (int i = 3; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            fibonacciCount += 1;
        }
        return fibo[n];
    }
}
