
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] credit = new double[20];
        double[] gradeValue = new double[20];

        for (int i = 0 ; i < 20; i++) {
                String s = sc.next();
                credit[i] = sc.nextDouble();
                String grade = sc.next();
                sc.nextLine();
                switch (grade) {
                    case "A+":
                    gradeValue[i] = 4.5;
                    break;
                    case "A0":
                    gradeValue[i] = 4.0;
                    break;
                    case "B+":
                    gradeValue[i] = 3.5;
                    break;
                    case "B0":
                    gradeValue[i] = 3.0;
                    break;
                    case "C+":
                    gradeValue[i] = 2.5;
                    break;
                    case "C0":
                    gradeValue[i] = 2.0;
                    break;
                    case "D+":
                    gradeValue[i] = 1.5;
                    break;
                    case "D0":
                    gradeValue[i] = 1.0;
                    break;
                    case "F":
                    gradeValue[i] = 0;
                    break;
                    case "P":
                    credit[i] = 0;
                    gradeValue[i] = 0;
                    break;
                }
        }

        double sum = 0.0;
        double creditSum = 0.0;
        for (int i = 0; i < 20; i++) {
            sum += credit[i] * gradeValue[i]; 
            creditSum += credit[i];
        }

        double avg = sum / creditSum;
        System.out.println(avg);
     }
    
}
