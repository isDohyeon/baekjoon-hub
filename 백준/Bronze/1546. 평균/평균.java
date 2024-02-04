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
        double[] arr = new double[n];

        for (int i = 0; i < n; i++)
        {
            int m = sc.nextInt();
            arr[i] = m;
        }
        Arrays.sort(arr);

        double maxScore = arr[n-1];
        double newScore;
        double sumScore = 0;

        for (int i = 0; i < n; i++)
        {
            newScore = (arr[i] / maxScore) * 100;
            arr[i] = newScore;
            sumScore += arr[i];
        }
        double avg = sumScore / n;

        System.out.print(avg);
    }
}