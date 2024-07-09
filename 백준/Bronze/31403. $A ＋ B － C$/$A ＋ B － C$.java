import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int intSum = 0;
        String stringSum = "";
        int stringSub = 0;
        for (int i = 0; i < 3; i++) {
            String n = br.readLine();
            if (i != 2) {
                intSum += Integer.parseInt(n);
                stringSum += n;
            } else {
                intSum -= Integer.parseInt(n);
                stringSub = Integer.parseInt(stringSum) - Integer.parseInt(n);
            }
        }
        bw.write(intSum +"\n"+ stringSub);
        bw.close();
    }
}
