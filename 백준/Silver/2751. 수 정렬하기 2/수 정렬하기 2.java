//package algorithm;

import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br;
    //private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> scores = sortListAscending(n);

        sb = new StringBuilder();
        for (Integer score : scores) {
            sb.append(score + "\n");
        }
        System.out.print(sb);
    }

    private static List<Integer> sortListAscending(int n) throws IOException {
        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(br.readLine()));
        }
        scores.sort(Comparator.naturalOrder());

        return scores;
    }
}