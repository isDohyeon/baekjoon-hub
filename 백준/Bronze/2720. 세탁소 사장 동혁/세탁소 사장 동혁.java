import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();  // 테스트 케이스 개수
        
        for (int i = 0; i < T; i++) {
            int C = scanner.nextInt();  // 거스름돈 센트 단위
            
            int quarters = C / 25;  // 쿼터의 개수
            C %= 25;
            
            int dimes = C / 10;  // 다임의 개수
            C %= 10;
            
            int nickels = C / 5;  // 니켈의 개수
            C %= 5;
            
            int pennies = C;  // 페니의 개수
            
            System.out.println(quarters + " " + dimes + " " + nickels + " " + pennies);
        }
        
        scanner.close();
    }
}
