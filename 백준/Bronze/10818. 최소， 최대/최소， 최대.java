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

        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        int min = arr[0];

        for (int j = 1; j < N; j++)
        {
            if (max < arr[j])
            {
                max = arr[j];
            }
        }
        for (int j = 1; j < N; j++)
        {
            if (min > arr[j])
            {
                min = arr[j];
            }
        }
        System.out.print(min + " " + max);
    }
}