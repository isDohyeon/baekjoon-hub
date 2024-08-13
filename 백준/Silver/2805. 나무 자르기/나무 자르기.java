//package algorithm.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(getMaxHeight(heights, M));
    }

    private static long getMaxHeight(int[] heights, long M) {
        long low = 0;
        long high = Arrays.stream(heights).max().getAsInt();

        while (low <= high) {
            long mid = (low + high) / 2;

            long total = 0;
            for (long height : heights) {
                if (height > mid) {
                    total += (height - mid);
                }
            }

            if (total >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
