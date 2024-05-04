//package CMD_BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int[] solution(int[] callStart, int[] callEnd, int[] tapStart, int[] tapEnd, int N, int M) {
        int[] answer = new int[M];
        // 도청 시간대가 겹치는지 확인
        for (int i = 0; i < M; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                // 도청 시작 시간 < 전화 끝나는 시간 && 도청 끝나는 시간 > 전화 시작 시간이면 도청 성공한 것
                if ((tapStart[i] < callEnd[j]) && (tapEnd[i] > callStart[j])) {
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

        // 입력값 토큰화 객체 (공백 기준 분리)
        StringTokenizer st;
        
        while (true) {
            // 1. N, M 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            // 2. Source, Destination, Start, Duration 입력
            int[] callStart = new int[N];
            int[] callEnd = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // Source : 의미없음
                st.nextToken(); // Destination : 의미없음
                callStart[i] = Integer.parseInt(st.nextToken()); // 통화 시작시간
                callEnd[i] = Integer.parseInt(st.nextToken()) + callStart[i]; // 통화 끝나는 시간 = 통화 시작시간 + 통화시간
            }

            //3. tapStart, tapEnd 입력
            int[] tapStart = new int[M];
            int[] tapEnd = new int[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                tapStart[i] = Integer.parseInt(st.nextToken()); // 도청 시작시간
                tapEnd[i] = Integer.parseInt(st.nextToken()) + tapStart[i]; // 도청 끝나는 시간 = 도청 시작시간 + 도청시간
            }
            // 결과값 출력
            int[] result = solution(callStart, callEnd, tapStart, tapEnd, N, M);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }
}
