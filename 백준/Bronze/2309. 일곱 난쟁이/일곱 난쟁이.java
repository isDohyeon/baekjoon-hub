//package CMD_Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static final int LENGTH = 9;

     public static int[] solution(int[] tall, int sum) {
         int[] answer = new int[LENGTH-2];
         
         outerLoop:
         // 난쟁이 두명씩 검사
         for (int i = 0; i < LENGTH -1; i++) {
            for (int j = i+1; j < LENGTH; j++) {
                if ((sum - (tall[i] + tall[j])) == 100) {
                    // 찾은 난쟁이 두명 빼고 정답 배열에 저장
                    int index = 0;
                    for (int k = 0; k < LENGTH; k++) {
                        if (k != i && k != j) {
                            answer[index] = tall[k];
                            index++;
                        }
                    }
                    // 중첩 반복문 바로 탈출
                    break outerLoop;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
         // 버퍼를 사용하여 입력받는 객체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] tall = new int[LENGTH];

        int sum = 0;
        // 난쟁이 키 입력받고 배열에 저장 후 더함
        for (int i = 0; i < LENGTH; i++) {
            tall[i] = Integer.parseInt(br.readLine());
            sum += tall[i];
        }
        // 입력받은 난쟁이 키 정렬
        Arrays.sort(tall);
        
        int[] result = solution(tall, sum);
        
        // 결과 출력
        for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        
    }
}