//package algorithm.brute_force;

import java.util.*;
import java.io.*;

public class Main {
    private static int height;
    private static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 모눈종이의 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        // 스티커의 수와 크기 입력
        int n = Integer.parseInt(br.readLine());
        int[] r = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        // 최댓값 초기화
        int maxArea = 0;

        // 두 스티커를 선택하는 모든 조합에 대해 최대 넓이 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxArea = Math.max(maxArea, getMaxArea(r[i], c[i], r[j], c[j]));
            }
        }

        // 결과 출력
        System.out.print(maxArea);
    }

    private static int getMaxArea(int r1, int c1, int r2, int c2) {
        int maxArea = 0;

        // 두 스티커의 회전 가능한 모든 경우를 확인
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
        // 두 스티커가 모눈종이 내에 유효하게 배치되는지 확인
        return (r1 + r2 <= height && Math.max(c1, c2) <= width) ||
               (r1 + r2 <= width && Math.max(c1, c2) <= height) ||
               (c1 + c2 <= height && Math.max(r1, r2) <= width) ||
               (c1 + c2 <= width && Math.max(r1, r2) <= height);
    }
}
