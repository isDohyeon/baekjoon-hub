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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++)
        {
            st = new StringTokenizer(br.readLine()," ");
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
        }
        br.close();

        bw.flush();
        bw.close();
    }
}