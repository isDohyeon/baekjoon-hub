//package implemention;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int n = 5;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            sum += input * input;
        }
        System.out.println(sum % 10);
    }
    
}
