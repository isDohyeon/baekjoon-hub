//package CMD_DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static int solution(int N, char[] S) {
        Stack<Character> stack = new Stack<>();
        // 1. N까지 반복
        // 2. 검사하는 괄호 모양과 다음 모양이 같은지 확인
        // - 같으면 스택에 넣고 카운트 증가
        // - 달라지면 맨 위의 값부터 제거
        // 3. 가장 큰 스택 사이즈가 정답
        // 4. 반복이 끝났는데 스택이 비어있지 않다면
        // -> 올바른 괄호가 아니므로 -1 반환

        int answer = 0;
        for (int i = 0; i < N; i++) {
            // 2
            if (stack.isEmpty() || stack.peek() == S[i]) {
                stack.push(S[i]);
            }
            else {
                stack.pop();
            }
            // 3
            if (answer < stack.size()) {
                answer = stack.size();
            }
        }
        // 4
        if (!stack.isEmpty()) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        // 버퍼를 사용하여 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력
        int N = Integer.parseInt(br.readLine());
        // S 입력
        char[] S = br.readLine().toCharArray();
        // 결과 출력
        System.out.println(solution(N, S));
    }
}
