//package CMD_Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static final int NUM = 9;

     public static int[] solution(int[] tall, int sum, int spyA, int spyB) {
        for (int i = 0; i < NUM-1; i++) {
            for (int j = i+1; j < NUM; j++) {
                if ((sum - (tall[i] + tall[j])) == 100) {
                    spyA = i;
                    spyB = j;
                    break;
                }
            }
        }

        int[] answer = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            if (i == spyA || i == spyB) {
                continue;
            }
            answer[i] = tall[i];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] tall = new int[NUM];
        int spyA = 0;
        int spyB = 0;
        int sum = 0;
        for (int i = 0; i < NUM; i++) {
            tall[i] = Integer.parseInt(br.readLine());
            sum += tall[i];
        }
        Arrays.sort(tall);

        int[] result = solution(tall, sum, spyA, spyB);

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                System.out.println(result[i]);
            }
        }

    }
}