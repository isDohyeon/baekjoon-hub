import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        pw.println("문제의 정답");
        pw.flush();
        pw.close();
    }
}
