import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        scanner.close();
        
        int diagonal = 1;
        int count = 1;
        
        // 대각선 찾기
        while (X > count) {
            diagonal++;
            count += diagonal;
        }
        
        int positionInDiagonal = X - (count - diagonal);
        
        int numerator;
        int denominator;
        
        if (diagonal % 2 == 0) {
            // 짝수 대각선
            numerator = positionInDiagonal;
            denominator = diagonal - positionInDiagonal + 1;
        } else {
            // 홀수 대각선
            numerator = diagonal - positionInDiagonal + 1;
            denominator = positionInDiagonal;
        }
        
        System.out.println(numerator + "/" + denominator);
    }
}
