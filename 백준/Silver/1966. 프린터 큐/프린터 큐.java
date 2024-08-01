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

            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> priorities = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priority));
                priorities.offer(priority);
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                Document current = queue.poll();

                if (current.priority == priorities.peek()) {
                    priorities.poll();
                    printOrder++;
                    if (current.index == m) {
                        sb.append(printOrder).append('\n');
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }

        System.out.print(sb);
    }

    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
