import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        for (int i = 0; i < N/4; i ++)
        {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}