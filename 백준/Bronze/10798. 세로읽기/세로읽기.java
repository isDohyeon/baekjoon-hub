
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[5][15];
        
        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();
            char[] token = new char[line.length()];
            for (int j = 0; j < line.length(); j++) {
                token[j] = line.charAt(j);
                arr[i][j] = Character.toString(token[j]);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == null) {
                    continue;
                }
                System.out.print(arr[j][i]);
            }
        }
        
    }
    
}
