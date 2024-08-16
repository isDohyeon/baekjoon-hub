//package algorithm.binary_search;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;

    private static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N];

        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        System.out.print(getMinTime(1, (long) M * maxTime));
    }

    private static long getMinTime(long min, long max) {
        while (min <= max) {
            long totalTime = (min + max) / 2;

            if (getJudgementCount(totalTime) < M) {
                min = totalTime + 1;
            } else {
                max = totalTime - 1;
            }
        }

        return min;
    }

    private static long getJudgementCount(long totalTime) {
        long count = 0;

        for (int time : times) {
            count += totalTime / time;
            
            if (count > M) {
                break;
            }
        }

        return count;
    }
}
