//package algorithm.math;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        while (min <= max) {
            if (isPrime(min)) {
                sb.append(min).append('\n');
            }
            min++;
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