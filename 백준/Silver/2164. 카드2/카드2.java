//package CMD_DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int solution(int N, Queue<Integer> queue) {
        // 1. 1~N 까지 큐에 넣기
        // 2. 큐의 맨 위의 값(가장 작은 값)을 버린다. -> remove
        // 3. 바로 그 다음 값(버린값 -1)을 저장한 뒤 맨 뒤로 넣는다. -> poll
        // 4. 이 과정들을 카드가 한 장 남을때 까지 반복한다. -> size

        // 1
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        // 2~4
        while (queue.size() != 1) {
            queue.remove();
            int pollValue = queue.poll();
            queue.add(pollValue);
        }

        int answer = queue.peek();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        // 버퍼를 사용하여 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정수형 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        //N값 입력
        int N = Integer.parseInt(br.readLine());
        // 결과 출력
        System.out.println(solution(N, queue));

    }
}
