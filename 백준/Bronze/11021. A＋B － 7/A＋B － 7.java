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
        int i,sum;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (i = 1; i < T + 1; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            sb.append("Case #" + i + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");

        }
        System.out.print(sb);
        br.close();
    }
}