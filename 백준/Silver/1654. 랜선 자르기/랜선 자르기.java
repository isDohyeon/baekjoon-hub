//package algorithm.binary_search;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lanCables = new int[k];

        for (int i = 0; i < k; i++) {
            lanCables[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lanCables);

        long left = 1;
        long right = lanCables[k - 1];
        long max = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (isCanMakeCables(lanCables, mid, n)) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(max);
    }

    private static boolean isCanMakeCables(int[] lanCables, long length, int n) {
        int count = 0;
        for (int cable : lanCables) {
            count += cable / length;
        }
        return count >= n;
    }
}