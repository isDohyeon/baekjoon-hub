import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        br.close();

        BufferedOutputStream bos = new BufferedOutputStream(System.out, 8192);
        // 버퍼 크기 예측: n * 6 (평균 5자리 숫자 + 줄바꿈 문자) -> 충분히 큰 버퍼
        byte[] buffer = new byte[n * 6];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            int start = index;

            if (num < 10) {
                buffer[index++] = (byte) ('0' + num);
            } else {
                while (num > 0) {
                    buffer[index++] = (byte) ('0' + num % 10);
                    num /= 10;
                }
                reverse(buffer, start, index - 1);
            }
            buffer[index++] = '\n';
        }

        bos.write(buffer, 0, index);
        bos.flush();
        bos.close();
    }

    private static void reverse(byte[] buffer, int start, int end) {
        while (start < end) {
            byte temp = buffer[start];
            buffer[start] = buffer[end];
            buffer[end] = temp;
            start++;
            end--;
        }
    }
}
