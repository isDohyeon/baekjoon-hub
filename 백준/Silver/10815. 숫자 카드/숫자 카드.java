//package algorithm;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Set<Integer> myCards = new HashSet<>();
        for (int i = 0; i < n; i++) {
            myCards.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }
        Map<Integer, Integer> map = getMapDuplicateCards(myCards, cards);
        StringBuilder sb = new StringBuilder();
        for (Integer value : map.values()) {
            sb.append(value).append(" ");
        }
        System.out.print(sb);
    }

    private static Map<Integer, Integer> getMapDuplicateCards(Set<Integer> myCards, List<Integer> cards) {
        Map<Integer, Integer> mapping = new LinkedHashMap<>();

        for (Integer card : cards) {
            if (myCards.contains(card)) {
                mapping.put(card, 1);
            } else {
                mapping.put(card, 0);
            }
        }
        
        return mapping;
    }
}
