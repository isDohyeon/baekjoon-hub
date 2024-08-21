//package algorithm.greedy;

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int K;

    private static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N];
        
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i);
        }

        System.out.print(getMaxCount());
    }

    private static int getMaxCount() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                // 현재 사람 위치에서 왼쪽으로 K까지 햄버거를 탐색
                for (int j = i - K; j <= i + K; j++) {
                    if (j >= 0 && j < N && arr[j] == 'H') {
                        // 매칭 가능한 햄버거를 발견했으면 매칭
                        arr[j] = 'X';  // 햄버거를 사용했음을 표시
                        count++;
                        break;  // 현재 사람은 햄버거를 먹었으므로 다음 사람으로 넘어감
                    }
                }
            }
        }

        return count;
    }
}
