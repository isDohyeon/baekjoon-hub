//package algorithm.data_structure;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            Map<String, Integer> fasionMap = new HashMap<>();

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {

                String key = br.readLine().split(" ")[1];

                fasionMap.put(key, fasionMap.getOrDefault(key, 0) + 1);
            }
            int result = 1;

            for (int count : fasionMap.values()) {
                result *= (count + 1);
            }

            sb.append(result - 1).append('\n');
        }
        System.out.print(sb);
    }
}