//package algorithm.greedy;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int K;

    private static int[] tall;
    private static List<TallGap> gap = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tall = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tall[i] = Integer.parseInt(st.nextToken());
            if (i > 0) {
                gap.add(new TallGap(i, tall[i] - tall[i - 1]));
            }
        }

        System.out.print(getMaxCost());
    }

    private static int getMaxCost() {
        int cost = 0;

        gap.sort(new Comparator<TallGap>() {
            @Override
            public int compare(TallGap o1, TallGap o2) {
                if (o1.gap == o2.gap) {
                    return o1.index - o2.index;
                }
                return o1.gap - o2.gap;
            }
        });

//        List<Integer> indexes = new ArrayList<>();
//        for (int i = 0; i < K - 1; i++) {
//            indexes.add(gap.get(i).index);
//        }
//
//        Collections.sort(indexes);
//        for (TallGap tallGap : gap) {
//            System.out.println("tallGap = " + tallGap.index + ", gap : " + tallGap.gap);
//        }

        int start = 0;
//        for (Integer index : indexes) {
//            cost += tall[index - 1] - tall[start];
//            start = index;
//        }
        for (int i = (N - 1) - (K - 1); i < N - 1; i++) {
            int index = gap.get(i).index;
//            System.out.println("i = " + i);
//            System.out.println("index = " + index);
            cost += tall[index - 1] - tall[start];
            start = index;
        }

        cost += tall[N - 1] - tall[start];

        return cost;
    }

    private static class TallGap {
        int index;
        int gap;

        public TallGap(int index, int gap) {
            this.index = index;
            this.gap = gap;
        }
    }
}