//package algorithm.math;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long lcm = getLcm(a, b);

        StringBuilder sb = new StringBuilder();
        sb.append(lcm).append('\n');
        System.out.print(sb);
    }

    private static long getLcm(long a, long b) {
        return Math.abs(a * b) / getGcd(a, b);
    }

    private static long getGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}