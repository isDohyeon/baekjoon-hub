//package algorithm.implementation;

import java.util.*;
import java.io.*;

public class Main {

    private static int C;
    private static int R;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (Integer i : getSeat()) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> getSeat() {
        List<Integer> seat = new ArrayList<>();

        if (C * R < K) {
            seat.add(0);
            return seat;
        }

        int x = 1;
        int y = 0;

        while (true) {
            for (int i = 0; i < R; i++) {
                y++;
                K--;
                if (K == 0) {
                    seat.add(x);
                    seat.add(y);
                    return seat;
                }
            }
            R--;

            for (int i = 0; i < C - 1; i++) {
                x++;
                K--;
                if (K == 0) {
                    seat.add(x);
                    seat.add(y);
                    return seat;
                }
            }
            C--;

            for (int i = 0; i < R; i++) {
                y--;
                K--;
                if (K == 0) {
                    seat.add(x);
                    seat.add(y);
                    return seat;
                }
            }
            R--;

            for (int i = 0; i < C - 1; i++) {
                x--;
                K--;
                if (K == 0) {
                    seat.add(x);
                    seat.add(y);
                    return seat;
                }
            }
            C--;
        }
    }
}