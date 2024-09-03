//package algorithm.implementation;

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[][] dice;

    public static void main(String[] args) throws IOException {
        /**
         * 주사위의 짝 인덱스 : 0, 5 / 1, 3 / 2, 4
         * 1번 주사위의 각 숫자에 대해서 (6가지의 경우)
         * 2번 주사위부터 쌓았을 경우 최댓값
         * 1. 1번 주사위의 6가지 수에 대한 쌓인 주사위 검사하기
         * 2. 인덱스에 대해 반대편 인덱스를 제외한 각 주사위의 최댓값 찾기
         * 3. 총 합을 갱신하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.print(getMaxSum());
    }

    private static int getMaxSum() {
        int max = 0;

        for (int i = 0; i < 6; i++) {
            int sum = 0;

            int topIndex = getTopIndex(i);
            int top = dice[0][topIndex];

            sum += getMaxValidNum(0, i, topIndex);

            for (int j = 1; j < N; j++) {
                for (int k = 0; k < 6; k++) {
                    if (dice[j][k] == top) {
                        topIndex = getTopIndex(k);
                        top = dice[j][topIndex];
                        sum += getMaxValidNum(j, k, topIndex);
                        break;
                    }
                }
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    private static int getTopIndex(int bottomIndex) {
        switch (bottomIndex) {
            case 0 :
                return 5;
            case 1 :
                return 3;
            case 2 :
                return 4;
            case 3 :
                return 1;
            case 4 :
                return 2;
            case 5 :
                return 0;
        }

        return 0;
    }

    private static int getMaxValidNum(int n, int bot, int top) {
        int max = 0;

        for (int i = 0; i < 6; i++) {
            int cur = dice[n][i];
            if (cur == dice[n][bot] || cur == dice[n][top]) {
                continue;
            }

            max = Math.max(max, cur);
        }
        return max;
    }
}