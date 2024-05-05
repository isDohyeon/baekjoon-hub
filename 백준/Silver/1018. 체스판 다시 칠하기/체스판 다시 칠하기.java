//package CMD_BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int solution(String[][] board, int N, int M) {
        // 1. 가능한 모든 경우의 보드판을 검사한다.
        // 2. 해당 위치를 기준으로 8x8 크기 보드의 변경(카운트) 횟수를 구한다.
        // 3. 시작부터 짝수 증가한 칸 -> 시작과 같은색 이어야 함 -> 다른 색이면 카운트
        // 4. 시작부터 홀수 증가한 칸 -> 시작과 다른색 이어야 함 -> 같은 색이면 카운트
        // 5. 검은색 시작 or 흰색 시작 중 최소 변경 횟수를 갱신하고 반환한다.

        int minCount = Integer.MAX_VALUE; // 구하려는 최솟값의 초기값 = 가장 큰 정수
        // 1
        for (int i = 0; i + 8 <= N; i++) {
            for (int j = 0; j + 8 <= M; j++) {
                int curCount = 0;
                // 2
                for (int x = j; x < j + 8; x++) {
                    for (int y = i; y < i + 8; y++) {
                        // 3
                        if ((x - j + y - i) % 2 == 0) {
                            if (!board[y][x].equals(board[i][j])) {
                                curCount += 1;
                            }
                        }
                        // 4
                        else if ((x - j + y - i) % 2 != 0){
                            if (board[y][x].equals(board[i][j])) {
                                curCount += 1;
                            }
                        }
                    }
                }
                // 5
                // 첫 번째 칸의 색깔 기준으로 할 때의 색칠 할 개수(curCount)와
                // 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의 색칠 할 개수(64 - curCount) 8x8이므로 모든 경우의 수 : 64
                // 중 최솟값(더 작은 값 = 최적의 값)을 curCount 로 설정
                if (64 - curCount < curCount) {
                    curCount = 64 - curCount;
                }
                // 최소 변경 횟수 갱신
                if (curCount < minCount) {
                    minCount = curCount;
                }
            }
        }
        return minCount;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] board = new String[N][M];

        for (int i = 0; i < N; i++) {
            // 한 줄을 읽고
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                // 공백 구분 없이 한 글자씩 읽으며 저장
                board[i][j] = String.valueOf(line.charAt(j));
            }
        }
        // 결과 출력
        System.out.println(solution(board, N, M));

    }
}
