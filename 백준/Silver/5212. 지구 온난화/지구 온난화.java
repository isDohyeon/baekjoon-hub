//package algorithm.implementation;

import java.io.*;
import java.util.*;

public class Main {

    private static int R;
    private static int C;
    private static char[][] map;

    private static int startX;
    private static int endX;

    private static int startY;
    private static int endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    checkCoord(i, j);
                }
            }
        }

        printMap();
    }

    private static void checkCoord(int y, int x) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = 0;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == '.') {
                count++;

                if (count >= 3) {
                    map[y][x] = 'O';
                    return;
                }
            }
        }
    }

    private static void printMap() {
        startX = 0;
        endX = C;
        startY = 0;
        endY = R;

        findValidLine();

        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (map[i][j] == 'O') {
                    System.out.print('.');
                    continue;
                }
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


    private static void findValidLine() {
        // 시작 Y 인덱스 찾기
        OuterLoop:
        for (int i = 0; i < R; i++) {
            int lineCount = 0;
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    break OuterLoop;
                }

                lineCount++;
                if (lineCount == C) {
                    startY++;
                }
            }
        }
        // 끝 y 찾기
        OuterLoop:
        for (int i = R - 1; i >= 0; i--) {
            int lineCount = 0;
            for (int j = C - 1; j >= 0; j--) {
                if (map[i][j] == 'X') {
                    break OuterLoop;
                }

                lineCount++;
                if (lineCount == C) {
                    endY--;
                }
            }
        }

        OuterLoop:
        for (int i = 0; i < C; i++) {
            int lineCount = 0;
            for (int j = 0; j < R; j++) {
                if (map[j][i] == 'X') {
                    break OuterLoop;
                }

                lineCount++;
                if (lineCount == R) {
                    startX++;
                }
            }
        }

        OuterLoop:
        for (int i = C - 1; i >= 0; i--) {
            int lineCount = 0;
            for (int j = R - 1; j >= 0; j--) {
                if (map[j][i] == 'X') {
                    break OuterLoop;
                }

                lineCount++;
                if (lineCount == R) {
                    endX--;
                }
            }
        }
    }
}
