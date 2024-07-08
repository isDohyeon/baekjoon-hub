//package implemention;

import java.util.*;

public class Main {
    /*
     * 1. 입력
     * 2. 문자열 길이만큼 반복 (작은 자릿수부터)
     * 3. 현재 자릿수 = 문자의 ASCII 값
     * 4. ASCII값 >= 65 라면 (A >= 라면)
     *  -> 현재 자릿수 ASCII 값 -65 (A = 10, Z = 35)
     *  -> 아니라면 -48 (0의 ASCII 값)
     * 5. 결과값 = 현재 진법의 cur번째 수 * (현재진법^자릿수)
     * 6. 자릿수가 증가함에 따라 현재진법^자릿수 증가
     * 7. 출력
     */
    public static void main(String[] args) {
        // 1
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        
        // 2
        int result = 0;
        int digit = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            // 3
            int cur = s.charAt(i);
            // 4
            cur = cur >= 65 ? cur - 55 : cur - 48;

            // 5
            result += cur * digit;
            // 6
            digit *= n;
        }
        // 7
        System.out.println(result);
    }
    
}
