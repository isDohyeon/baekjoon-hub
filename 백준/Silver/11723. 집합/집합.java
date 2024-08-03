import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        
        int bitSet = 0;  // 비트마스크를 사용할 변수
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            
            switch (command) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    bitSet |= (1 << (x - 1));
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    bitSet &= ~(1 << (x - 1));
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if ((bitSet & (1 << (x - 1))) != 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    bitSet ^= (1 << (x - 1));
                    break;
                case "all":
                    bitSet = (1 << 20) - 1;
                    break;
                case "empty":
                    bitSet = 0;
                    break;
            }
        }
        
        System.out.print(sb.toString());
    }
}
