
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 1. 입력
         * 2. 입력 길이만큼 반복
         * 3. 크로아티아 알파벳 갯수만큼 반복
         * 4. 해당 인덱스 위치부터 크로아티아 알파벳으로 시작한다면
         * -> 문자열의 카운트 길이를, 크로아티아 알파벳 길이-1 만큼 차감 
         *    길이-1 만큼 인덱스 위치를 뒤로 이동
         * 5. 결과 출력
         */

        // 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int countLength = input.length();

        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 2
        for (int i = 0; i < input.length(); i++) {
            // 3
            for (int j = 0; j < croatia.length; j++) {
                // 4
                if (input.startsWith(croatia[j], i)) {
                    countLength -= (croatia[j].length() - 1);
                    i += (croatia[j].length() - 1);
                    break;
                }
            }
        }

        // 5
        System.out.println(countLength);
    }
}
