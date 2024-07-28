//package algorithm;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            count += getCounts(s, input);
        }
        
        System.out.println(count);
    }

    private static int getCounts(Set<String> s, String input) {
        return s.contains(input) ? 1 : 0;
    }
}
