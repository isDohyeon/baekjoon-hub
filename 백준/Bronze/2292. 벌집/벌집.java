//package implemention;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // 1, 7, 19, 37, 61
        // 1, +6, +12, +18, +24
        // an = a(n-1)+6n
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num == 1) {
            System.out.println(1);
            return;
        }

        int n = 1;
        int an = 1;

        while (an < num) {
            if (an == num) {
                n -= 1;
                break;
            }
            an += 6 * n;
            n++;
        }

        System.out.println(n);
    }
}
