//package CMD_BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int solution(int N) {
        int count = 0;

        if (N % 5 == 0) {
            count = N / 5;
        } else {
            while (N >= 0) {
                N -= 3;
                count++;
                if (N % 5 == 0) {
                    count += N / 5;
                    break;
                }
            }
            if (N < 0) {
                count = -1;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = solution(N);

        System.out.println(result);
    }
}
