import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // Directions for moving up, down, left, right
    static int[] dy = {0, 0, -1, 1}; // Directions for moving up, down, left, right

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = scanner.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> clusterSizes = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int clusterSize = dfs(i, j);
                    clusterSizes.add(clusterSize);
                }
            }
        }

        Collections.sort(clusterSizes);
        
        System.out.println(clusterSizes.size());
        for (int size : clusterSizes) {
            System.out.println(size);
        }

        scanner.close();
    }

    private static int dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return count;
    }
}
