//package week01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[][] rectangle;
    private static int size;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            rectangle = new int[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    rectangle[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }
            size = Math.min(N, M);
            if (size == 1) {
                bw.write(String.valueOf(1));
                return;
            }
            while (size > 1) {
                if (findSquare(N, M)) {
                    break;
                }
                size--;
            }
            bw.write(String.valueOf(size * size));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean findSquare(int N, int M) {
        for (int i = 0; i <= N - size; i++) {
            for (int j = 0; j <= M - size; j++) {
                int sizeIndex = size - 1;
                int topLeft = rectangle[i][j];
                int topRight = rectangle[i][j + sizeIndex];
                int bottomLeft = rectangle[i + sizeIndex][j];
                int bottomRight = rectangle[i + sizeIndex][j + sizeIndex];
                if (isSamePoints(topLeft, topRight, bottomLeft, bottomRight)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSamePoints(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        return topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight;
    }
}
