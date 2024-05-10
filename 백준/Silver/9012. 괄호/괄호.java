//package CMD_DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static String[] solution(int N, Stack<Character> stack, String[] input) {
        String[] answer = new String[N];

        outerLoop:
        for (int i = 0; i < N; i++) {
            // 한줄을 한글자씩 스택에 넣음
            int length = input[i].length();
            for (int j = 0; j < length; j++) {
                // ( 라면 검사 시작 -> ( 라면 스택에 넣고
                if (input[i].charAt(j) == '(') {
                    stack.push('(');
                }
                // ) 라면 맨 위를 지움
                else if (input[i].charAt(j) == ')') {
                    // 지우려는데 ) 라면 올바르지 않은 VPS -> NO
                    if (stack.empty()) {
                        answer[i] = "NO";
                        stack.clear();
                        // 밑의 조건문이 실행되지 않기 위함
                        continue outerLoop;
                    }
                    stack.pop();
                }
            }

            // 한줄 다 검사했을 때 스택이 비어있다면 올바른 VPS 이므로 -> YES
            if (stack.empty()) {
                answer[i] = "YES";
            }
            // 스택이 비어있지 않다면 올바르지 않은 VPS 이므로 -> NO
            else {
                answer[i] = "NO";
            }
            // 다음 줄을 처리하기 위해 스택 비우기
            stack.clear();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Char 형 스택
        Stack<Character> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        // 한 줄씩 입력받기
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        // 결과값 출력
        String[] result = solution(N, stack, input);
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}
