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
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++)
        {
            int n = sc.nextInt();
            arr[i] = n % 42;
        }
        Arrays.sort(arr);
        int count = 1;
        for (int j = 0; j < 10; j++)
        {
            if (j != 0 && (arr[j] != arr[j-1]))
            {
                count++;
            }
        }
        //if (count == 0) count = 1;

        System.out.print(count);

    }
}