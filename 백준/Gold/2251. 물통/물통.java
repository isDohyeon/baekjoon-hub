//package algorithm.dfs_bfs;

import java.util.*;
import java.io.*;

public class Main {

    private static int A;
    private static int B;
    private static int C;

    private static boolean[][][] visited; // 방문처리: A, B, C의 상태를 모두 고려
    private static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[A + 1][B + 1][C + 1]; // 3차원 배열로 방문 처리

        bfs(0, 0, C);

        Collections.sort(results);

        for (Integer result : results) {
            sb.append(result).append(" ");
        }
        System.out.print(sb);
    }

    private static void bfs(int a, int b, int c) {
        Queue<int[]> waterAmount = new LinkedList<>();
        waterAmount.offer(new int[]{a, b, c});
        visited[a][b][c] = true;

        while (!waterAmount.isEmpty()) {
            int[] buckets = waterAmount.poll();

            if (buckets[0] == 0) {
                results.add(buckets[2]);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        continue;
                    }
                    // i에서 j로 물을 옮기는 로직
                    int[] newBuckets = pourWater(buckets, i, j);

                    // 새로운 상태를 방문했는지 확인하고, 방문하지 않았으면 큐에 추가
                    if (!visited[newBuckets[0]][newBuckets[1]][newBuckets[2]]) {
                        visited[newBuckets[0]][newBuckets[1]][newBuckets[2]] = true;
                        waterAmount.offer(new int[]{newBuckets[0], newBuckets[1], newBuckets[2]});
                    }
                }
            }
        }
    }

    private static int[] pourWater(int[] buckets, int from, int to) {

        int maxAmount;
        if (to == 0) {
            maxAmount = A;
        } else if (to == 1) {
            maxAmount = B;
        } else {
            maxAmount = C;
        }

        int fromAmount = buckets[from];
        int toAmount = buckets[to];
        int trans = Math.min(fromAmount, maxAmount - toAmount);

        int[] newBuckets = buckets.clone();
        newBuckets[from] -= trans;
        newBuckets[to] += trans;

        return newBuckets;
    }
}