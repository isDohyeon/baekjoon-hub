import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long result = factorial(n);
        System.out.println(result);
    }

    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        } 
    }
}
