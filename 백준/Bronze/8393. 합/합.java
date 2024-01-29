import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int sum = 0;

        for (int i = 0; i < N + 1; i ++)
        {
            sum += i;
        }
        System.out.print(sum);
    }
}