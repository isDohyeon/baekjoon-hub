//package algorithm.math;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numerator1 = Integer.parseInt(st.nextToken());
        int denominator1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int numerator2 = Integer.parseInt(st.nextToken());
        int denominator2 = Integer.parseInt(st.nextToken());

        int numerator = (numerator1 * denominator2) + (numerator2 * denominator1);
        int denominator = denominator1 * denominator2;
        int gcd = getGcd(numerator, denominator);

        int fractionNum = numerator / gcd;
        int fractionDen = denominator / gcd;

        System.out.print(fractionNum + " " + fractionDen);
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}