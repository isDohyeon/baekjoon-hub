//package algorithm.dynamic_programming;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(getFibo(n));
    }

    private static long getFibo(int n) {
        if (n <= 1) {
            return n;
        }

        long fibo = 0;
        long a = 0;
        long b = 1;

        for (int i = 2; i <= n; i++) {
            fibo = a + b;
            a = b;
            b = fibo;
        }
        return fibo;
    }
}