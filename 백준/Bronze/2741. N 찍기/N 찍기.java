//package implemention;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Scanner 입력, BufferedWriter 출력
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
