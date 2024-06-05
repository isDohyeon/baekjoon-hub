import javax.sound.midi.Soundbank;
import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static double iArray[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
    static double avg = 0;
    static double sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = 0;
        int x = 0, y = 0;
        for(int i = 1; i <= 9 ; i++){
            for(int j = 1; j <= 9 ; j++){
                int temp = scan.nextInt();
                if(max <= temp){
                    max = temp;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.print(x);
        System.out.print(' ');
        System.out.print(y);
    }
}