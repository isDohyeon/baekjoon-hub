//package algorithm;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cards = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());
            sb.append(getCardCounts(cards, card)).append(" ");
        }
        System.out.print(sb);
    }

    private static int getCardCounts(Map<Integer, Integer> cards, int card) {
        return cards.getOrDefault(card, 0);
    }
}