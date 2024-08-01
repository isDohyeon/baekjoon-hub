import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] priorities = new int[n];
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                priorities[i] = priority;
                queue.offer(i);
                maxHeap.offer(priority);
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                int currentIndex = queue.poll();

                if (priorities[currentIndex] == maxHeap.peek()) {
                    maxHeap.poll();
                    printOrder++;
                    if (currentIndex == m) {
                        sb.append(printOrder).append('\n');
                        break;
                    }
                } else {
                    queue.offer(currentIndex);
                }
            }
        }

        System.out.print(sb);
    }
}
