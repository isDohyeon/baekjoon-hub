import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        if (N == 1) {
            return; // N이 1인 경우 아무것도 출력하지 않음
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                System.out.println(i);
                N /= i;
            }
        }

        // 남은 숫자가 소수인 경우 출력
        if (N > 1) {
            System.out.println(N);
        }
    }
}
