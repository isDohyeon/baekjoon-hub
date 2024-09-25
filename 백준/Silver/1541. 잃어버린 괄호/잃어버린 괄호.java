import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        sc.close();
        
        // "-"를 기준으로 문자열을 분리
        String[] subtractions = expression.split("-");

        // 첫 번째 부분은 무조건 더해줌
        int result = sumOf(subtractions[0]);
        
        // 나머지 부분들은 모두 빼줌
        for (int i = 1; i < subtractions.length; i++) {
            result -= sumOf(subtractions[i]);
        }
        
        System.out.println(result);
    }

    // "+"로 구분된 숫자들의 합을 계산하는 함수
    private static int sumOf(String expression) {
        String[] additions = expression.split("\\+");
        int sum = 0;
        for (String add : additions) {
            sum += Integer.parseInt(add);
        }
        return sum;
    }
}
