import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        BufferedOutputStream bos = new BufferedOutputStream(System.out, 32768);

        byte[] buffer = new byte[588895];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (i < 10) buffer[index++] = (byte)(i + '0');
            else if (i < 100) {
                buffer[index++] = (byte)(i / 10 + '0');
                buffer[index++] = (byte)(i % 10 + '0');
            }
            else if (i < 1000) {
                buffer[index++] = (byte)(i / 100 + '0');
                buffer[index++] = (byte)((i / 10) % 10 + '0');
                buffer[index++] = (byte)(i % 10 + '0');
            }
            else if (i < 10000) {
                buffer[index++] = (byte)(i / 1000 + '0');
                buffer[index++] = (byte)((i / 100) % 10 + '0');
                buffer[index++] = (byte)((i / 10) % 10 + '0');
                buffer[index++] = (byte)(i % 10 + '0');
            }
            else if (i < 100000) {
                buffer[index++] = (byte)(i / 10000 + '0');
                buffer[index++] = (byte)((i / 1000) % 10 + '0');
                buffer[index++] = (byte)((i / 100) % 10 + '0');
                buffer[index++] = (byte)((i / 10) % 10 + '0');
                buffer[index++] = (byte)(i % 10 + '0');
            }
            else {
                buffer[index++] = '1';
                buffer[index++] = '0';
                buffer[index++] = '0';
                buffer[index++] = '0';
                buffer[index++] = '0';
                buffer[index++] = '0';
            }
            buffer[index++] = '\n';
        }

        bos.write(buffer, 0, index);
        bos.flush();
    }
}