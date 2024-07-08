import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    // BufferedReader 입력, StringTokenizer 분리, byte 배열 저장 후 write 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        byte[] buffer = new byte[10 * n];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            String numStr = Integer.toString(i);
            for (char c : numStr.toCharArray()) {
                buffer[index++] = (byte) c;
            }
            buffer[index++] = '\n';
        }
        
        System.out.write(buffer, 0, index);
    }
}
