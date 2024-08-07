//package algorithm.dfs;

import java.io.*;
import java.util.*;

public class Main {

    private static final int N = 5;
    private static int[][] board = new int[N][N];
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static Set<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        /**
         * 1. 5x5 크기의 숫자판을 입력 받는다.
         * 2. 모든 위치에서 시작하여 가능한 모든 6자리 수를 탐색한다.
         * 3. 탐색한 6자리 수에 대해 중복되지 않도록 저장한다.
         * 4. 저장된 수들의 개수를 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                findNumbers(i, j, 0, board[i][j]);
            }
        }

        // 4
        System.out.print(numberSet.size());
    }

    private static void findNumbers(int x, int y, int depth, int number) {
        // 3
        if (depth == 5) {
            numberSet.add(number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                findNumbers(nx, ny, depth + 1, (number * 10) + board[nx][ny]);
            }
        }
    }
}
