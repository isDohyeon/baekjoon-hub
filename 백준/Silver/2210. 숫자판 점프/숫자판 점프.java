//package algorithm.dfs;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] board;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static Set<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = 5;
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                findNumbers(i, j, 0, board[i][j]);
            }
        }

        System.out.print(numberSet.size());
    }

    private static void findNumbers(int x, int y, int depth, int number) {
        if (depth == 5) {
            numberSet.add(number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                findNumbers(nx, ny, depth + 1, number * 10 + board[nx][ny]);
            }
        }
    }
}
