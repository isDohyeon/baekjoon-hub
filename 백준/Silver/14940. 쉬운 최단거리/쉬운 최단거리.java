import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;      // 지도 정보 (0: 못 감, 1: 갈 수 있음, 2: 목표)
    static int[][] dist;     // 최단 거리 저장 배열
    static boolean[][] visited;
    // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        // 목표 지점 좌표
        int ty = -1, tx = -1;

        // 지도 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;  // 초기 -1로 세팅 (방문 전)
                if (map[i][j] == 2) {
                    ty = i;
                    tx = j;
                }
            }
        }

        // BFS: 목표 지점에서 시작
        bfs(ty, tx);

        // 출력
        // 원래 갈 수 없는 땅(0)은 0 출력, 도달 못하면 -1, 그 외 거리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    sb.append(0).append(" ");
                } else if (map[i][j] == 2) {
                    sb.append(0).append(" ");  // 목표지점은 거리 0
                } else { // 원래 1
                    // dist[i][j]가 -1이면 도달 불가능, 아니면 거리
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void bfs(int sy, int sx) {
        // 시작점(목표 지점)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sy, sx});
        visited[sy][sx] = true;
        dist[sy][sx] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                // 범위 검사
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                // 갈 수 있는 땅(1)이고 방문 안 했으면
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[cy][cx] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}