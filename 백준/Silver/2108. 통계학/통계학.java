//package algorithm.math;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        sb.append(getAvg(numbers)).append('\n');
        sb.append(getMiddle(numbers)).append('\n');
        sb.append(getMaxFrequency(numbers)).append('\n');
        sb.append(getRange(numbers)).append('\n');

        System.out.print(sb);
    }

    private static int getRange(int[] numbers) {
        return numbers[numbers.length - 1] - numbers[0];

    }

    private static int getMaxFrequency(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = 0;
        for (int freq : frequencyMap.values()) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }

        List<Integer> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                freqList.add(entry.getKey());
            }
        }

        if (freqList.size() == 1) {
            return freqList.get(0);
        } else {
            Collections.sort(freqList);
            return freqList.get(1);
        }
    }

    private static int getMiddle(int[] numbers) {
        return numbers[numbers.length / 2];
    }

    private static long getAvg(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return Math.round((double) sum / numbers.length);
    }
}