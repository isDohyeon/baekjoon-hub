import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int A,B;
        int[] AB = new int[N];

        for (int i = 0; i < N; i++)
        {

            A = input.nextInt();
            B = input.nextInt();
            AB[i] = A+B;
        }
        for (int output : AB)
        {
            System.out.println(output);
        }
    }
}