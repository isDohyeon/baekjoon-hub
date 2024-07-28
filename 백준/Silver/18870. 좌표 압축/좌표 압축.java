//package algorithm;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coordinates = new int[n];
        for (int i = 0; i < n; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
        }

        int[] compressedCoordinates = getCompressedCoordinates(coordinates, n);
        StringBuilder sb = new StringBuilder();
        for (int result : compressedCoordinates) {
            sb.append(result).append(" ");
        }
        System.out.print(sb);
    }

    private static int[] getCompressedCoordinates(int[] coordinates, int length) {
        int[] sorted = Arrays.copyOf(coordinates, length);
        Arrays.sort(sorted);

        Map<Integer, Integer> compressedValue = new HashMap<>();
        int compIndex = 0;
        for (int i : sorted) {
            if (!compressedValue.containsKey(i)) {
                compressedValue.put(i, compIndex++);
            }
        }

        int[] compressedCoordinates = new int[length];
        for (int i = 0; i < length; i++) {
            compressedCoordinates[i] = compressedValue.get(coordinates[i]);
        }
        return compressedCoordinates;
    }
}
