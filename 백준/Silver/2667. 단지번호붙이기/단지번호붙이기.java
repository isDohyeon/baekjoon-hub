import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> complexes = findComplex(matrix);
        System.out.println(complexes.size());
        for (int complex : complexes) {
            System.out.println(complex);
        }
    }

    public static List<Integer> findComplex(int[][] matrix) {
        int n = matrix.length;
        boolean[][] visited = new boolean[n][n];
        List<Integer> complexes = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    count++;
                    int complexCount = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        complexCount++;

                        int x = curr[0];
                        int y = curr[1];

                        if (x > 0 && matrix[x - 1][y] == 1 && !visited[x - 1][y]) {
                            queue.offer(new int[]{x - 1, y});
                            visited[x - 1][y] = true;
                        }

                        if (x < n - 1 && matrix[x + 1][y] == 1 && !visited[x + 1][y]) {
                            queue.offer(new int[]{x + 1, y});
                            visited[x + 1][y] = true;
                        }

                        if (y > 0 && matrix[x][y - 1] == 1 && !visited[x][y - 1]) {
                            queue.offer(new int[]{x, y - 1});
                            visited[x][y - 1] = true;
                        }

                        if (y < n - 1 && matrix[x][y + 1] == 1 && !visited[x][y + 1]) {
                            queue.offer(new int[]{x, y + 1});
                            visited[x][y + 1] = true;
                        }
                    }
                    complexes.add(complexCount);
                }
            }
        }
        Collections.sort(complexes);
        return complexes;
    }
}