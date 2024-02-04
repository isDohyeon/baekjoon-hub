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
        int[] myBasket = new int[n];

        int m = sc.nextInt();
        for (int x = 0; x < n; x++)
        {
            myBasket[x] = x + 1;
        }
        int temp = 0;
        for (int a = 0; a < m; a++)
        {
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;
            while (i < j)
            {
                temp = myBasket[i];
                myBasket[i] = myBasket[j];
                myBasket[j] = temp;
                i++;
                j--;
            }
        }
        for (int i = 0; i < n; i++)
        {
            System.out.print(myBasket[i] + " ");
        }



    }
}