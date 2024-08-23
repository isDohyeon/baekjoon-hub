//package algorithm.greedy;

import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static Integer[] A;
    private static Integer[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        A = new Integer[a];
        B = new Integer[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMaxBeauty(a - 1, b - 1));
    }

    private static int getMaxBeauty(int indexA, int indexB) {
        int maxBeauty = 0;
        int tileArea = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        if (N % 2 == 1) {
            maxBeauty += A[indexA];
            indexA--;
            tileArea++;
        }

        while (tileArea < N) {
            int tileA = indexA >= 1 ? A[indexA] + A[indexA - 1] : 0;
            int tileB = indexB >= 0 ? B[indexB] : 0;

            if (tileA > tileB) {
                maxBeauty += tileA;
                indexA -= 2;
                tileArea += 2;
            } else {
                maxBeauty += tileB;
                indexB--;
                tileArea += 2;
            }
        }

        return maxBeauty;
    }
}