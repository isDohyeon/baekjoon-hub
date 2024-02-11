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
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++)
        {
            int r = in.nextInt();
            String s = in.next();
            for (int j = 0; j < s.length(); j++)
            {
                for (int k = 0; k < r; k++)
                {
                    System.out.print((s.charAt(j)));
                }
            }
            System.out.println();
        }
    }
}