import java.io.BufferedReader; // 입력
import java.io.BufferedWriter; // 출력
import java.io.IOException; // 예외처리
import java.util.Arrays;
import java.util.StringTokenizer; // 문자열 분리
import java.io.InputStreamReader; // 입력 스트림
import java.io.OutputStreamWriter; // 출력 스트림
import java.util.Scanner;

class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 2 * n - 1; i++)
        {
            for (int j = 0; j < n-i; j++)
            {
                System.out.print(" ");
            }

            if (i <= n)
            {
                for (int k = 0; k < 2 * i - 1; k++)
                {
                    System.out.print("*");
                }
            }
            else
            {
                for (int j = 0; j < i - n; j ++)
                {
                    System.out.print(" ");
                }
                for (int k = 0; k < (4 * n - 1) - (2 * i); k++)
                {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
