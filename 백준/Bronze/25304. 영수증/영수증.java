import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int X = input.nextInt();
        int N = input.nextInt();
        int sum = 0;

        for (int i = 0; i < N; i ++)
        {
            int a = input.nextInt();
            int b = input.nextInt();
            sum += a*b;
        }
        System.out.print(X == sum ? "Yes" : "No");
    }
}