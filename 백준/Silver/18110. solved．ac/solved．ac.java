//package algorithm.math;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] difficulties = new int[n];

        for (int i = 0; i < n; i++) {
            difficulties[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(difficulties);

        int rounded15Percent = (int) Math.round((double) n * 0.15);

        double sum = 0;
        for (int i = rounded15Percent; i < n - rounded15Percent; i++) {
            sum += difficulties[i];
        }

        int roundedAvg = (int) Math.round(sum / (n - 2 * rounded15Percent));
        System.out.print(roundedAvg);
    }
}