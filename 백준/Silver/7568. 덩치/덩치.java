// package bruteforce;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
         * 1. 입력 - 정수형 2차원배열 n * 2
         * 2. 하나씩 모든 조건 검사
         * - if 검사 대상의 키와 몸무게가 둘 다 적다면
         * -> 순위 값 증가
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] people = new int[n][2];

        // 1
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(input[0]);
            people[i][1] = Integer.parseInt(input[1]);
        }

        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        // 2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank[i]++;
                }
            }
        }

        for (int result : rank) {
            System.out.print(result + " ");
        }
    }
}