//package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX = 100_000;

    private static int N;
    private static int K;
    private static int[] time = new int[MAX + 1];
    private static int[] way = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(time, -1);
        time[N] = 0;
        way[N] = 1;
        bfs();
        bw.write(time[K] + "\n" + way[K]);
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int position = queue.poll();
            for (int nextPosition : new int[]{position - 1, position + 1, position * 2}) {
                if (!isValidPosition(nextPosition)) {
                    continue;
                }

                if (time[nextPosition] == -1) {
                    time[nextPosition] = time[position] + 1;
                    way[nextPosition] = way[position];
                    queue.offer(nextPosition);
                    continue;
                }
                if (time[nextPosition] == time[position] + 1) {
                    way[nextPosition] += way[position];
                }
            }
        }
    }

    private static boolean isValidPosition(int position) {
        return position >= 0 && position <= MAX;
    }
}
