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
        int count = 0;
        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }
        int v = sc.nextInt();

        for (int j = 0; j < N; j++)
        {
            if (v == arr[j])
            {
                count++;
            }
        }
        System.out.print(count);


    }
}