//package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int T;
    private static int H;
    private static int W;

    private static char[][] grid;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int sheepGroup;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            grid = new char[H][W];
            visited = new boolean[H][W];
            sheepGroup = 0;

            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    grid[i][j] = input.charAt(j);
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && grid[i][j] == '#') {
                        visited[i][j] = true;
                        dfs(i, j);
                        sheepGroup++;
                    }
                }
            }
            sb.append(sheepGroup).append('\n');
        }

        System.out.print(sb);
    }

    private static void dfs(int y, int x) {

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];

            int nx = x + dx[i];

            if (isValidSheep(ny, nx)) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }

    private static boolean isValidSheep(int ny, int nx) {
        return nx >= 0 && ny >= 0 && nx < W && ny < H && grid[ny][nx] == '#' && !visited[ny][nx];
    }
}
