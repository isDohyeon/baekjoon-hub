//package algorithm.math;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            while (true) {
                if (isPrime(num)) {
                    break;
                }
                num++;
            }
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        } else if (num <= 3) {
            return true;
        } else if ((num % 2 == 0) || (num % 3 == 0)) {
            return false;
        }

        long sqrtNum = (long) Math.sqrt(num);
        for (long i = 5; i <= sqrtNum; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}