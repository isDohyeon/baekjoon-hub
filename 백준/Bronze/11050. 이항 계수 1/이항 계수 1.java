// package implemention;

import java.io.*;
import java.util.StringTokenizer;
public class Main {
    
    private static StringTokenizer st;
    private static int n;
    private static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        solution();
        
    }
    
    private static void solution() {
        int fN = 1;
        for (int i = 1; i <= n; i++) {
            fN *= i;
        }
        
        int fK = 1;
        for (int i = 1; i <= k; i++) {
            fK *= i;
        }

        int nSubK = n - k;
        int fNSubK = 1;
        for (int i = 1; i <= nSubK; i++) {
            fNSubK *= i;
        }
        int answer = fN / (fK * fNSubK);
        System.out.println(answer);
    }

}
