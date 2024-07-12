//package implemention;

import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        int n = Integer.parseInt(br.readLine());

        int[] count = new int[10001];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < count.length; i++) {
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        // String -> byte
        bos.write(sb.toString().getBytes());
        bos.flush();
        bos.close();
    }
}
