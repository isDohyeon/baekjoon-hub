//package implemention;

import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> result = new ArrayList<>();

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            int length = s.length();

            boolean isFelindrom = true;
            for (int i = 0; i < length / 2; i++) {
                if (s.charAt(i) != s.charAt(length - i - 1)) {
                    isFelindrom = false;
                    break;
                }
            }

            result.add(isFelindrom ? "yes" : "no");
        }
        for (String output : result) {
            System.out.println(output);
        }
    }
}
