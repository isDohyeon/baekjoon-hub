//package algorithm.dynamic_programming;

import java.util.*;
import java.io.*;

public class Main {

    private static Map<Integer, Long> fiboMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());

        System.out.print(getFibonacciNumber(n));
    }

    private static long getFibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        }

        if (fiboMap.containsKey(n)) {
            return fiboMap.get(n);
        }

        long result = getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        fiboMap.put(n, result);
        return result;
    }
}