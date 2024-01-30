import java.io.BufferedReader; // 입력받기
import java.io.BufferedWriter; // 출력하기
import java.io.IOException; // 예외처리
import java.util.StringTokenizer; // 문자열 ()단위로 저장
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int A,B;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < T + 1; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append("Case #" + i + ": " + A + " + " + B + " = " + (A+B) + "\n");

        }
        System.out.print(sb);
        br.close();
    }
}