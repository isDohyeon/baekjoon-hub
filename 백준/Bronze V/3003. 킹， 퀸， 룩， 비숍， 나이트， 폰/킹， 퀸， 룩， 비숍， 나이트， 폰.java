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

        int[] chess = {1, 1, 2, 2, 2, 8};
        int[] output = new int[6];
        for (int i = 0; i < chess.length; i++)
        {
            int input = sc.nextInt();
            output[i] = chess[i] - input;
        }
        for (int num : output)
        {
            System.out.print(num + " ");
        }
    }
}
