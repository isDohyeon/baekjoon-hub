import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 수행 횟수는 n^3
        long count = (long) n * n * n;
        
        // 수행 횟수 출력
        System.out.println(count);

        // 최고차항 차수 출력
        int highestDegree = 3;
        if (highestDegree > 3) {
            highestDegree = 4;
        }
        System.out.println(highestDegree);
    }
}
