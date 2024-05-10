//package CMD_DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static int[] solution(int N, int[] input, PriorityQueue<Integer> pq) {
        // input 의 요소값이 0인 경우를 카운트 = countZero
        // 입력값이 0이라면 배열의 최대 값을 삭제 후 -> 정답 배열에 저장
        // 입력값이 자연수라면 해당 값을 배열에 삽입
        
        int countZero = 0;
        for (int i = 0; i < N; i++) {
            if (input[i] == 0) {
                countZero++;
            }
        }

        int index = 0;
        int[] answer = new int[countZero];

        for (int i = 0; i < N; i++) {
            if (input[i] == 0) {
                pq.add(input[i]);
                answer[index++] = pq.poll();
            }
            else {
                pq.add(input[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int[] result = solution(N, input, pq);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
