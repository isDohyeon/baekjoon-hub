//package algorithm.brute_force;

import java.util.*;
import java.io.*;

public class Main {

    private static int height;
    private static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] r = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxArea = Math.max(maxArea, getMaxArea(r[i], c[i], r[j], c[j]));
            }
        }

        System.out.print(maxArea);
    }

    private static int getMaxArea(int r1, int c1, int r2, int c2) {
        int maxArea = 0;

        int[][] pair1 = {{r1, c1}, {c1, r1}};
        int[][] pair2 = {{r2, c2}, {c2, r2}};

        for (int[] p1 : pair1) {
            for (int[] p2 : pair2) {
                int pr1 = p1[0];
                int pc1 = p1[1];
                int pr2 = p2[0];
                int pc2 = p2[1];

                if (isValidStickers(pr1, pc1, pr2, pc2)) {
                    maxArea = Math.max(maxArea, pr1 * pc1 + pr2 * pc2);
                }
            }
        }

        return maxArea;
    }

    private static boolean isValidStickers(int r1, int c1, int r2, int c2) {
        return (r1 + r2 <= height && Math.max(c1, c2) <= width) ||
                (r1 + r2 <= width && Math.max(c1, c2) <= height) ||
                (c1 + c2 <= height && Math.max(r1, r2) <= width) ||
                (c1 + c2 <= width && Math.max(r1, r2) <= height);
    }
}
