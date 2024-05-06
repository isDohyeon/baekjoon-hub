//package CMD_BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int[] solution(int a, int b, int abAnswer, int c, int d, int cdAnswer) {
        int x = -1000;
        int y = 0;

        outerLoop:
        while (x < 1000) {
            y = -1000;
            x++;
            while (y < 1000) {
                y++;
                if (((a * x) + (b * y) == abAnswer) && ((c * x) + (d * y) == cdAnswer)) {
                    break outerLoop;
                }
            }
        }

        int[] answer = {x, y};
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int abAnswer = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int cdAnswer = Integer.parseInt(st.nextToken());

        int[] result = solution(a, b, abAnswer, c, d, cdAnswer);
        System.out.println(result[0] + " " + result[1]);
    }
}
