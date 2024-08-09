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
    private static List<Integer> groups = new ArrayList<>();

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
                    visited[i][j] = true;

                    bfs(i, j);

                    groups.add(count);
                    count = 0;
                }
            }
        }

        groups.sort(Comparator.naturalOrder());

        sb.append(groups.size()).append('\n');
        for (Integer groupSize : groups) {
            sb.append(groupSize).append('\n');
        }

        System.out.print(sb);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> home = new LinkedList<>();
        home.offer(new int[]{y, x});

        while (!home.isEmpty()) {
            int[] current = home.poll();
            count++;
            int curY = current[0];
            int curX = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (isValidHome(ny, nx)) {
                    visited[ny][nx] = true;
                    home.offer(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean isValidHome(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == '1' && !visited[ny][nx];
    }
}
