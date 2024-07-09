//package implemention;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int multiple = 1;
        for (int i = 0; i < 3; i++) {
            multiple *= Integer.parseInt(br.readLine());
        }

        int[] checkNum = new int[10];
        String s = String.valueOf(multiple);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 10; j++) {
                if ((s.charAt(i) - '0') == j) {
                    checkNum[j] += 1;
                }
            }
        }

        for (int i : checkNum) {
            System.out.println(i);
        }

    }
    
}
