//package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX = 100_000;

    private static int N;
    private static int K;
    private static int[] time;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[MAX + 1];
        bfs();
        bw.write(String.valueOf(result));
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
             int position = queue.poll();

            if (position == K) {
                result = time[position] - 1;
                return;
            }

            if (isValidPosition(position + 1)) {
                time[position + 1] = time[position] + 1;
                queue.offer(position + 1);
            }
            if (isValidPosition(position - 1)) {
                time[position - 1] = time[position] + 1;
                queue.offer(position - 1);
            }
            if (isValidPosition(position * 2)) {
                time[position * 2] = time[position] + 1;
                queue.offer(position * 2);
            }
        }
    }

    private static boolean isValidPosition(int position) {
        return position >= 0 && position <= MAX && time[position] == 0;
    }
}
