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
        int[] arr = new int[30];

        for (int i = 0; i < 28; i++)
        {
            int n = sc.nextInt();
            arr[n-1] = n;
        }
        for (int j = 0; j < 30; j++)
        {
            if (arr[j] == 0)
            {
                System.out.println(j+1);
            }
        }

    }
}