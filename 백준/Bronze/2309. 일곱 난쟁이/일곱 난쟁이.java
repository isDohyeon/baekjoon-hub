//package CMD_Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static final int LENGTH = 9;

     public static int[] solution(int[] tall, int sum) {
         int[] answer = new int[LENGTH -2];
         outerLoop:
         for (int i = 0; i < LENGTH -1; i++) {
            for (int j = i+1; j < LENGTH; j++) {
                if ((sum - (tall[i] + tall[j])) == 100) {
                    int index = 0;
                    for (int k = 0; k < LENGTH; k++) {
                        if (k != i && k != j) {
                            answer[index] = tall[k];
                            index++;
                        }
                    }
                    break outerLoop;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] tall = new int[LENGTH];

        int sum = 0;
        for (int i = 0; i < LENGTH; i++) {
            tall[i] = Integer.parseInt(br.readLine());
            sum += tall[i];
        }
        Arrays.sort(tall);

        int[] result = solution(tall, sum);

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                System.out.println(result[i]);
            }
        }

    }
}