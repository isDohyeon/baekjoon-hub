//package algorithm.dfs_bfs;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] area;
    private static boolean[][] visited;

    private static int[] dx = {0, 0, -1, 1,  1, 1, -1, -1};
    private static int[] dy = {-1, 1, 0, 0, -1, 1,  1, -1};

    private static Queue<int[]> coordinates = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                area[i][j] = input;
                if (input == 1) {
                    coordinates.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        System.out.print(getMaxDistance());
    }

    private static int getMaxDistance() {
        int maxDistance = 0;

        while (!coordinates.isEmpty()) {
            int[] coordinate = coordinates.poll();
            int x = coordinate[1];
            int y = coordinate[0];
            int curDistance = coordinate[2];

            maxDistance = Math.max(maxDistance, curDistance);

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValidCoordinate(ny, nx)) {
                    visited[ny][nx] = true;
                    coordinates.offer(new int[]{ny, nx, curDistance + 1});
                }
            }
        }

        return maxDistance;
    }

    private static boolean isValidCoordinate(int ny, int nx) {
        return nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx];
    }
}
