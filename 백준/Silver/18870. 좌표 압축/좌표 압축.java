//package algorithm;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 입력의 크기 n을 읽어들임
        int n = Integer.parseInt(br.readLine());

        // 두 번째 줄에서 좌표 값을 읽어들임
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coordinates = new int[n];
        for (int i = 0; i < n; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
        }

        // 좌표 압축을 수행하고 결과를 얻음
        int[] compressedCoordinates = compressCoordinates(coordinates);

        // 결과를 StringBuilder 에 추가
        StringBuilder sb = new StringBuilder();
        for (int result : compressedCoordinates) {
            sb.append(result).append(" ");
        }

        // 결과를 출력
        System.out.print(sb);
    }

    /**
     * 주어진 좌표 배열을 압축하여 새로운 배열을 반환
     *
     * @param coordinates 주어진 좌표 배열
     * @return 압축된 좌표 배열
     */
    private static int[] compressCoordinates(final int[] coordinates) {
        // 원본 배열을 복사하여 정렬
        int[] sorted = Arrays.copyOf(coordinates, coordinates.length);
        Arrays.sort(sorted);

        // 좌표를 압축된 값으로 매핑
        Map<Integer, Integer> compressedMap = new HashMap<>();
        int compressedIndex = 0;
        for (int value : sorted) {
            if (!compressedMap.containsKey(value)) {
                compressedMap.put(value, compressedIndex++);
            }
        }

        // 원본 좌표 배열을 압축된 값으로 변환
        int[] compressedCoordinates = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            compressedCoordinates[i] = compressedMap.get(coordinates[i]);
        }

        return compressedCoordinates;
    }
}
