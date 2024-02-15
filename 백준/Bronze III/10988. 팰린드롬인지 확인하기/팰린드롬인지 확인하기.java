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
        String s = sc.next();
        int n = s.length();
        int out = 1;
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) != s.charAt(n-i-1))
            {
                out = 0;
            }
        }
        System.out.print(out);
    }
}
