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

        String s = in.next();

        int sum = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char a = s.charAt(i);

            switch (a)
            {
                case 'A':
                case 'B':
                case 'C':
                    sum += 3;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    sum += 4;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    sum += 5;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    sum += 6;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    sum += 7;
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    sum += 8;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    sum += 9;
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    sum += 10;
                    break;
                default:
            }
        }
        System.out.print(sum);
    }
}
