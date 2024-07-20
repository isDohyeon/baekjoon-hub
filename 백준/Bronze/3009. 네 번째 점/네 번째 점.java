import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        
        // 좌표 입력 받기
        for (int i = 0; i < 3; i++) {
            x.add(sc.nextInt());
            y.add(sc.nextInt());
        }
        
        int resultX = findFourthCoordinate(x);
        int resultY = findFourthCoordinate(y);
        
        System.out.println(resultX + " " + resultY);
        
        sc.close();
    }
    
    private static int findFourthCoordinate(ArrayList<Integer> coords) {
        if (coords.get(0).equals(coords.get(1))) {
            return coords.get(2);
        } else if (coords.get(0).equals(coords.get(2))) {
            return coords.get(1);
        } else {
            return coords.get(0);
        }
    }
}
