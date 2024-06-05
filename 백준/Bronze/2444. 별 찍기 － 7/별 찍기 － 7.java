import java.util.*;
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for (int i = 1; i <= N * 2 - 1; i++) {
            for(int j = 1; j <= ((i / N) * (i % N) * 2) + N - i ; j++)
                System.out.print(' ');
            for (int k = 1; k <= (1+2*(i-1))-((i/N)*(i%N)*4)	; k++)
                System.out.print('*');
            System.out.println();
        }
    }
}