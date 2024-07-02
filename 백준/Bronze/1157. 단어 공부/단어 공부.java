import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();  // 대문자로 변환

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'A']++;
        }

        int maxFreq = 0;
        char maxChar = '?';
        boolean isMultiple = false;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxChar = (char) (i + 'A');
                isMultiple = false;
            } else if (freq[i] == maxFreq) {
                isMultiple = true;
            }
        }

        if (isMultiple) {
            System.out.println("?");
        } else {
            System.out.println(maxChar);
        }
        
    }
}
