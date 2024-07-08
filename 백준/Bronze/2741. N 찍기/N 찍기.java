import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
    // 성능 개선 실험
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        BufferedOutputStream bos = new BufferedOutputStream(System.out, 8192);

        byte[] buffer = new byte[n * 11];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            int digits = 0;

            while (num > 0) {
                num /= 10;
                digits++;
            }

            num = i;
            int start = index + digits - 1;
            while (num > 0) {
                buffer[start--] = (byte) ('0' + num % 10);
                num /= 10;
            }

            index += digits;
            buffer[index++] = '\n';
        }

        bos.write(buffer, 0, index);
        bos.flush();
    }
}
