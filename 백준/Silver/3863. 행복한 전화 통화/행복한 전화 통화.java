//package CMD_BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int[] solution(int[] start, int[] des, int[] tapStart, int[] tapDur, int N, int M) {
        int[] answer = new int[M];

        for (int i = 0; i < M; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (tapStart[i] < (start[j] + des[j]) && (tapStart[i] + tapDur[i]) > start[j]) {
                    count += 1;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        // 버퍼를 사용하여 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String nm = br.readLine();
            StringTokenizer nmToken = new StringTokenizer(nm, " ");
            // 1. 정수 N과 M입력
            int N = Integer.parseInt(nmToken.nextToken()); // 전화통화 횟수
            int M = Integer.parseInt(nmToken.nextToken()); // 도청 횟수
            if (N == 0 && M == 0) {
                break;
            }

            int[] source = new int[N];
            int[] dest = new int[N];
            int[] start = new int[N];
            int[] dur = new int[N];
            // 2. Source, Destination, Start, Duration 입력
            for (int i = 0; i < N; i++) {
                String call = br.readLine();
                StringTokenizer callToken = new StringTokenizer(call, " ");

                source[i] = Integer.parseInt(callToken.nextToken());
                dest[i] = Integer.parseInt(callToken.nextToken());
                start[i] = Integer.parseInt(callToken.nextToken());
                dur[i] = Integer.parseInt(callToken.nextToken());
            }
            //3. tapStart, tapDur 입력
            int[] tapStart = new int[M];
            int[] tapDur = new int[M];
            for (int i = 0; i < M; i++) {
                String tap = br.readLine();
                StringTokenizer tapToken = new StringTokenizer(tap, " ");

                tapStart[i] = Integer.parseInt(tapToken.nextToken());
                tapDur[i] = Integer.parseInt(tapToken.nextToken());
            }
            int[] result = solution(start, dur, tapStart, tapDur, N, M);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }
}
