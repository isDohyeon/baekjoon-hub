//package algorithm.math;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            sb.append(count).append('\n');
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
            if ((num % i) == 0 || (num % (i + 2) == 0)) {
                return false;
            }
        }
        return true;
    }
}