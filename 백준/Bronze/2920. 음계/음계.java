//package implemention;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[8];
        for (int i = 0; i < 8; i++) {
            n[i] = sc.nextInt();
        }

        String result = "";
        for (int i = 0; i < 8; i++) {
            if (i > 0) {
                if (n[i] == n[i-1] + 1) {
                    result = "ascending";
                } else if (n[i] == n[i-1] - 1) {
                    result = "descending";
                } else {
                    result = "mixed";
                    break;
                }
            }
        }
        System.out.println(result);
    }
    
}
