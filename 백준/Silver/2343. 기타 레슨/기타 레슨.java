//package algorithm.binary_search;

import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] durations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        durations = new int[N];

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int maxDuration = 0;

        for (int i = 0; i < N; i++) {
            durations[i] = Integer.parseInt(st.nextToken());
            sum += durations[i];
            maxDuration = Math.max(maxDuration, durations[i]);
        }

        System.out.print(getMinBluRay(maxDuration, sum));
    }

    private static int getMinBluRay(int min, int max) {

        while (min <= max) {
            int bluRaySize = (min + max) / 2;

            if (getBluRayCount(bluRaySize) > M) {
                min = bluRaySize + 1;
            } else {
                max = bluRaySize - 1;
            }
        }

        return min;
    }

    private static int getBluRayCount(int bluRaySize) {
        int sum = 0;
        int count = 0;

        for (int duration : durations) {
            if (sum + duration <= bluRaySize) {
                sum += duration;
            } else {
                count++;
                sum = duration;
            }
        }

        return count + 1;
    }
}