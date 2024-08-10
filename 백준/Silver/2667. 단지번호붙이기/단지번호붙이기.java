//package algorithm.dfs_bfs;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;

    private static char[][] map;
    private static boolean[][] visited;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static int count;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == '1') {
                    dfs(i, j);
                    result.add(count);
                    count = 0;
                }
            }
        }

        result.sort(Comparator.naturalOrder());

        sb.append(result.size()).append('\n');
        for (Integer groupSize : result) {
            sb.append(groupSize).append('\n');
        }

        System.out.print(sb);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValidHome(ny, nx)) {
                dfs(ny, nx);
            }
        }
    }

    private static boolean isValidHome(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == '1' && !visited[ny][nx];
    }
}

