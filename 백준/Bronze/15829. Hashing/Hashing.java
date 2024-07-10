//package datastructure;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String l = br.readLine();

        long hashValue = 0;
        long r = 1;
        int mod = 1234567891;

        for (int i = 0; i < n; i++) {
            int key = l.charAt(i) - 'a' + 1;
            hashValue = (hashValue + key * r) % mod;
            r = (r * 31) % mod;
        }

        bw.write(Long.toString(hashValue));
        bw.flush();
        bw.close();
    }
}
