//package implemention;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        sc.nextLine();
        int[] result = new int[n];


        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int temp = 0;
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    count++;
                    temp += count;
                } else {
                    count = 0;
                }
            }
            result[i] = temp;
        }

        for (int output : result) {
            System.out.println(output);
        }
    }
    
}
