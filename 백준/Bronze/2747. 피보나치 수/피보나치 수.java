//package algorithm.dynamic_programming;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        Map<Integer, Long> fiboMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        System.out.print(getFibonacciNumber(n, fiboMap));
    }

    private static long getFibonacciNumber(int n, Map<Integer, Long> fiboMap) {
        if (n <= 1) {
            return n;
        }

        if (fiboMap.containsKey(n)) {
            return fiboMap.get(n);
        }

        long result = getFibonacciNumber(n - 1, fiboMap) + getFibonacciNumber(n - 2, fiboMap);
        fiboMap.put(n, result);
        return result;
    }
}