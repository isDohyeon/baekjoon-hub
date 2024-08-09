//package algorithm.dfs_bfs;

import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        bfs(1);

        System.out.print(count);
    }

    private static void bfs(int start) {
        Queue<List<Integer>> computers = new LinkedList<>();
        computers.offer(graph[start]);
        visited[start] = true;

        while (!computers.isEmpty()) {
            List<Integer> num = computers.poll();

            for (Integer i : num) {
                if (!visited[i]) {
                    visited[i] = true;
                    computers.offer(graph[i]);
                    count++;
                }
            }
        }
    }
}
