
import java.io.*;

public class Main {
    /*
     * 각 문자가 이전에 나타났는지 여부를 저장하는 배열
     * 그룹 단어인지 여부를 저장하는 변수
     * 이전 문자를 저장하는 변수
     * 이전 문자와 현재 문자가 다르고 현재 문자가 이전에 나타났다면 그룹 단어가 아님
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            boolean[] seen = new boolean[26];
            boolean isGroupWord = true;
            char prevChar = 0;

            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);

                
                if (currentChar != prevChar) {
                    if (seen[currentChar - 'a']) {
                        isGroupWord = false;
                        break;
                    }
                    seen[currentChar - 'a'] = true;
                    prevChar = currentChar;
                }
            }

            if (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);
    }
}
