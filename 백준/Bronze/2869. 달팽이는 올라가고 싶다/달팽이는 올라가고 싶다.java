import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 거리
        int B = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 거리
        int V = Integer.parseInt(st.nextToken()); // 목표 높이
        
        int days = (V - B - 1) / (A - B) + 1; // 소수점 올림, 마지막날 + 1
        
        System.out.println(days);
    }
}
