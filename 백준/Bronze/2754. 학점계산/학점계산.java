import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Double> gradeToPoint = new HashMap<>();
        gradeToPoint.put("A+", 4.3);
        gradeToPoint.put("A0", 4.0);
        gradeToPoint.put("A-", 3.7);
        gradeToPoint.put("B+", 3.3);
        gradeToPoint.put("B0", 3.0);
        gradeToPoint.put("B-", 2.7);
        gradeToPoint.put("C+", 2.3);
        gradeToPoint.put("C0", 2.0);
        gradeToPoint.put("C-", 1.7);
        gradeToPoint.put("D+", 1.3);
        gradeToPoint.put("D0", 1.0);
        gradeToPoint.put("D-", 0.7);
        gradeToPoint.put("F", 0.0);

        Scanner sc = new Scanner(System.in);
        String grade = sc.next();
        System.out.println(gradeToPoint.get(grade));
    }
}
