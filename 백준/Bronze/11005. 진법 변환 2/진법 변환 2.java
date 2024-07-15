import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        
        // 변환 결과 저장할 StringBuilder
        StringBuilder result = new StringBuilder();
        
        // B진법 변환
        while (N > 0) {
            int remainder = N % B;
            if (remainder < 10) {
                result.append((char)(remainder + '0'));
            } else {
                result.append((char)(remainder - 10 + 'A'));
            }
            N /= B;
        }
        
        // 결과 뒤집기
        System.out.println(result.reverse().toString());
    }
}
