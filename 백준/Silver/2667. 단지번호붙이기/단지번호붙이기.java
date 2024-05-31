//package cmd_dfsbfs;

import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static List<Integer> answer;

    static int[]dx = {0, 0, -1, 1};
    static int[]dy = {-1, 1, 0, 0};
    static boolean[][] visited;

    static int n;
    static int[][] input;

    private static List<Integer> solution(int n, int[][] input) {
        answer = new LinkedList<>();

        count = 1;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(input[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    answer.add(count);
                    count = 1;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && input[nx][ny]==1){
                count++;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n 입력
        n = Integer.parseInt(br.readLine());
        // 총 단지 입력
        visited = new boolean[n][n];
        input = new int[n][n];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        // 결과 출력
        List<Integer> result = solution(n, input);
        System.out.println(result.size());
        for (int i : result) {
            System.out.println(i);
        }
    }
}
