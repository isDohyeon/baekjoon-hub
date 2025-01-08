//package week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Integer> eurekaSeq = new ArrayList<>();

    public static void main(String[] args) {
        int num;
        int n = 0;
        while (true) {
            n++;
            num = (n * (n + 1)) / 2;
            if (num >= 1000) {
                break;
            }
            eurekaSeq.add(num);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] answers = new int[N];
            for (int i = 0; i < N; i++) {
                int number = Integer.parseInt(br.readLine());
                if (isSumOfThreeTriangleNumbers(number)) {
                    answers[i] = 1;
                    continue;
                }
                answers[i] = 0;
            }
            for (int i = 0; i < N; i++) {
                bw.write(String.valueOf(answers[i]));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSumOfThreeTriangleNumbers(int number) {
        int size = eurekaSeq.size();
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                for (int l = 0; l < size; l++) {
                    if (eurekaSeq.get(j) + eurekaSeq.get(k) + eurekaSeq.get(l) == number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
