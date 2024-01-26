import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.print((a>=90&&a<=100) ? "A" : ((a<90&&a>=80) ? "B" : ((a<80&&a>=70) ? "C" : ((a<70&&a>=60) ? "D" : "F"))));



    }
}