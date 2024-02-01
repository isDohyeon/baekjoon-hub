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

        //int N = 9;

        int[] arr = new int[9];
        int max = arr[0];
        int line = 0;
        for (int i = 0; i < 9; i++)
        {
            arr[i] = sc.nextInt();
            if (max < arr[i])
            {
                max = arr[i];
                line = i+1;
            }
        }
        System.out.print(max + "\n" + line);

    }
}