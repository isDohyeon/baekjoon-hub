//package algorithm.dynamic_programming;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        System.out.print(getFibonacciNumber(n));
    }

    private static int getFibonacciNumber(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int fib = 0;
        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }
}