//package algorithm;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> unheardSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unheardSet.add(br.readLine());
        }

        List<String> unSeenList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (unheardSet.contains(input)) {
                unSeenList.add(input);
            }
        }

        unSeenList.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.valueOf(unSeenList.size())).append('\n');
        for (String result : unSeenList) {
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}