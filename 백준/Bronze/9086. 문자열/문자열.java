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

        String name[] = new String[n];

        for(int i=0;i<n;i++) {
            String str = sc.next();
            name[i] = str.substring(0,1)+ str.substring(str.length()-1,str.length());
        }

        sc.close();

        for(int i=0;i<n;i++) {
            System.out.println(name[i]);
        }
    }
}