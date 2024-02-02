import java.io.BufferedReader; // 입력
import java.io.BufferedWriter; // 출력
import java.io.IOException; // 예외처리
import java.util.StringTokenizer; // 문자열 분리
import java.io.InputStreamReader; // 입력 스트림
import java.io.OutputStreamWriter; // 출력 스트림
import java.util.Scanner;

class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] myBasket = new int[N];
        int M = sc.nextInt();

        for (int a = 0; a < M; a++)
        {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            for (int b = i; b <= j; b++)
            {
                myBasket[b-1] = k;
            }
        }
        for (int i = 0; i < myBasket.length; i++)
        {
            System.out.print(myBasket[i] + " ");
        }


    }
}