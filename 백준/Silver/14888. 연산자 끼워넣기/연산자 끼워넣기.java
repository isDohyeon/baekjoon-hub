//package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] A;
    private static final List<Character> operators = new ArrayList<>();
    private static final char[] operator = {'+', '-', '*', '/'};

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int opNums = Integer.parseInt(st.nextToken());
            for (int j = 0; j < opNums; j++) {
                operators.add(operator[i]);
            }
        }
        findAnswer(A[0], 1);
        bw.write(max + "\n" + min);
        bw.flush();
    }

    private static void findAnswer(int number, int depth) {
        if (depth == N) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }
        for (int i = 0; i < operators.size(); i++) {
            char operator = operators.remove(i);
            findAnswer(calculateNextNumber(number, A[depth], operator), depth + 1);
            operators.add(i, operator);
        }
    }

    private static int calculateNextNumber(int num1, int num2, char operator) {
        switch (operator) {
            case '+' :
                return num1 + num2;
            case '-' :
                return num1 - num2;
            case '*' :
                return num1 * num2;
            case '/' :
                return num1 / num2;
        }
        return 0;
    }
}
