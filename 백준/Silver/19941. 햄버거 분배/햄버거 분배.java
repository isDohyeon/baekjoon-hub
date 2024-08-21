import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int K;

    private static char[] arr;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N];
        visited = new boolean[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i);
        }

        System.out.print(getMaxCount());
    }

    private static int getMaxCount() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int index = Math.max(i - K, 0);

                while (true) {
                    if (index >= N || index > i + K) {
                        break;
                    }

                    if (arr[index] == 'H') {
                        arr[index] = 'X';
                        count++;
                        break;
                    }

                    index++;
                }
            }
        }

        return count;
    }
}