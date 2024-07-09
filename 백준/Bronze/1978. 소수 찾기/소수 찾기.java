//package implemention;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = n;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                count--;
                continue;
            }
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
