import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] 도화지 = new boolean[100][100];
        int count = 0;

        int 색종이수 = sc.nextInt();
        for(int i = 0; i < 색종이수; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            for(int j = y; j < y+10; j++) {
                for(int k = x; k < x+10; k++) {
                    if(!도화지[j][k]) {
                        도화지[j][k] = true;
                        count += 1;
                    }
                    else {
                        continue;
                    }
                }
            }
        }
        System.out.println(count);

    }
}