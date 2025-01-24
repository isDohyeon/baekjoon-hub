//package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX = 100_000;

    private static int N;
    private static int K;
    private static int[] time = new int[MAX + 1];
    private static int[] way = new int[MAX + 1];
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. N, K 입력 및 시간 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(time, -1);
        Arrays.fill(way, -1);
        // 2. 너비 우선 탐색
        bfs();
        // 3. 결과 출력
        bw.write(result + "\n");
        int last = K;
        List<Integer> path = new ArrayList<>();
        while (last != -1) {
            path.add(last);
            last = way[last];
        }
        Collections.reverse(path);
        for (Integer i : path) {
            bw.write(i + " ");
        }
        bw.close();
    }

    private static void bfs() {
        // bfs 큐 생성 및 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
             int position = queue.poll();
            // 큐에서 꺼낸 위치가 K(동생 위치)와 같다면
            if (position == K) {
                // 해당 위치까지 걸린 시간이 정답
                result = time[position];
                return;
            }
            // 각 케이스(위치 -1, +1, *2)가
            // 올바른 위치라면 큐에 삽입 후 시간 갱신
            for (int nextPosition : new int[]{position - 1, position + 1, position * 2}) {
                if (!isValidPosition(nextPosition)) {
                    continue;
                }
                time[nextPosition] = time[position] + 1;
                queue.offer(nextPosition);
                way[nextPosition] = position;
            }
        }
    }

    // 위치의 유효한 범위, 방문 여부를 검사
    private static boolean isValidPosition(int position) {
        return position >= 0 && position <= MAX && time[position] == -1;
    }
}
