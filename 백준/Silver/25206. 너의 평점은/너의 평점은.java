import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static double iArray[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
    static double avg = 0;
    static double sum = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i< 20; i++){
            String name = scan.next();
            double score = scan.nextDouble();
            String point = scan.next();
            if(point.equals("P")){
                continue;
            }
            else if(point.equals("A+")){
                avg += score * iArray[0];

            }else if(point.equals("A0")){
                avg += score * iArray[1];

            }else if(point.equals("B+")){
                avg += score * iArray[2];

            }else if(point.equals("B0")){
                avg += score * iArray[3];

            }else if(point.equals("C+")){
                avg += score * iArray[4];

            }else if(point.equals("C0")){
                avg += score * iArray[5];

            }else if(point.equals("D+")){
                avg += score * iArray[6];

            }else if(point.equals("D0")){
                avg += score * iArray[7];
            }
            sum += score;
        }
        System.out.println(avg / sum);
    }
}