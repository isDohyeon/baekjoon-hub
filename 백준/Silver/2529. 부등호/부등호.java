//package algorithm.brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int K;
    private static char[] equalitySigns;
    private static boolean[] visited = new boolean[10];

    private static String min;
    private static String max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        equalitySigns = new char[K];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            equalitySigns[i] = st.nextToken().charAt(0);
        }

        findMaxMin(0, "");

        System.out.println(max);
        System.out.print(min);
    }

    private static void findMaxMin(int length, String number) {
        if (length == K + 1) {
            if (min == null || max == null) {
                max = number;
                min = number;
            }

            max = number.compareTo(max) == 1 ? number : max;
            min = number.compareTo(min) == -1 ? number : min;
            return;
        }

        for (int current = 0; current <= 9; current++) {
            if (!visited[current]) {
                if (length == 0 || getCompareResult(current, number)) {
                    visited[current] = true;
                    findMaxMin(length + 1, number + current);
                    visited[current] = false;
                }
            }
        }
    }

    private static boolean getCompareResult(int curNum, String number) {
        int lastNum = number.charAt(number.length() - 1) - '0';
        char sign = equalitySigns[number.length() - 1];

        return sign == '>' ? lastNum > curNum : lastNum < curNum;
    }
}
