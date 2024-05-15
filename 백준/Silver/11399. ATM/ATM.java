import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사람 수 N 입력 받기
        int N = scanner.nextInt();
        
        // 각 사람이 돈을 인출하는데 걸리는 시간 Pi 입력 받기
        int[] withdrawalTimes = new int[N];
        for (int i = 0; i < N; i++) {
            withdrawalTimes[i] = scanner.nextInt();
        }
        scanner.close();

        // 최소 시간을 구하기 위해 인출 시간을 정렬
        Arrays.sort(withdrawalTimes);

        int totalTime = 0;
        int accumulatedTime = 0;

        // 각 사람이 돈을 인출하는데 필요한 시간의 합 계산
        for (int time : withdrawalTimes) {
            accumulatedTime += time;
            totalTime += accumulatedTime;
        }

        // 결과 출력
        System.out.println(totalTime);
    }
}
