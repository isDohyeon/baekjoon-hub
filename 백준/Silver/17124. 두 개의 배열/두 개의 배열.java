//package algorithm.binary_search;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] A;
    private static int[] B;
    private static int[] C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            A = new int[n];
            B = new int[m];
            C = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);

            sb.append(getCSum()).append('\n');
        }

        System.out.print(sb);
    }

    private static long getCSum() {
        long sum = 0;
        for (int i : getArrC()) {
            sum += i;
        }
        return sum;
    }

    private static int[] getArrC() {
        for (int i = 0; i < A.length; i++) {
            int value = A[i];

            int start = 0;
            int end = B.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (B[mid] < value) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (start >= B.length) {
                C[i] = B[B.length - 1];
            } else if (end < 0) {
                C[i] = B[0];
            } else {
                C[i] = Math.abs(value - B[end]) <= Math.abs(value - B[start]) ? B[end] : B[start];
            }
        }

        return C;
    }
}
