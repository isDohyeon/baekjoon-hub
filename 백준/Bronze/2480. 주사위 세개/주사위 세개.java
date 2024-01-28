import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int output;

        if (a == b && b == c)
        {
            output = 10000 + a * 1000;
        }
        else if (a == b || b == c)
        {
            output = 1000 + b * 100;
        }
        else if (a == c)
        {
            output = 1000 + c * 100;
        }
        else
        {
            if (a > b && a > c)
            {
                output = a * 100;
            }
            else if (b > a && b > c)
            {
                output = b * 100;
            }
            else output = c * 100;
        }
        System.out.print(output);



    }
}