import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int count = 1;
        while (A != B)
        {
            if (A > B)
                break;
            else if (B % 2 == 0)
            {
                B /= 2;
            }
            else if (B % 10 == 1)
            {
                B = (B - 1) / 10;
            }
            else
                break;

            count++;
        }
        System.out.print(A == B ? count : -1);
    }
}