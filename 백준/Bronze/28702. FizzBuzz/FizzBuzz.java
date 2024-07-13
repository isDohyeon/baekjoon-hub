//package implemention;

import java.io.*;

public class Main {
    
    private static BufferedReader br;
    private static String in;
    private static int intIn;
    private static int index;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        // 정수로 변환이 가능한지 검사 후 인덱스 get.
        for (int i = 1; i <= 3; i++) {
            in = br.readLine();
            if (isNumber()) {
                intIn = Integer.parseInt(in);
                index = 4 - i;
            }
        }

        String result = getResult();
        System.out.println(result);
    }
    // 정수임?
    private static boolean isNumber() {
        try {
            Integer.parseInt(in);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // 정답 여기염
    private static String getResult() {
        int answer = intIn + index;
        if (answer % 15 == 0) {
            return "FizzBuzz";
        } else if (answer % 3 == 0) {
            return "Fizz";
        } else if (answer % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(answer);
        }
    }
}
