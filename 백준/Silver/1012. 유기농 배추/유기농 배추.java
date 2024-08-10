//package algorithm.dfs_bfs;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int K;

    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int count;

    public static void main(String[] args) throws IOException{
        /**
         * 1. 테스트 케이스 입력
         * 2. 배추밭, 배추 개수 입력
         * 3. 입력받은 배추밭 좌표배열에 배추 저장
         * 4. 배추가 존재한다면 bfs
         * 5. bfs 끝날 때마다 카운트 증가
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (!visited[y][x] && map[y][x] == 1) {
                        bfs(y, x);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
            count = 0;
        }

        System.out.print(sb);
    }

    private static void bfs(int b, int a) {
        Queue<int[]> queue = new LinkedList<>();
        visited[b][a] = true;
        queue.offer(new int[]{b, a});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValidCoord(ny, nx)) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean isValidCoord(int ny, int nx) {
        return nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] == 1 && !visited[ny][nx];
    }
}
