import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); // 사용자에게 입력을 받기 위한 Scanner 객체 생성

        int N = in.nextInt(); // N정수 입력(예시코드의 5)
        int M = in.nextInt(); // M정수 입력(예시코드의 21)

        int[] arr = new int[N]; //카드의 개수인 N을 배열로 생성

        for (int i = 0; i < N; i++) { // N번 반복하며 입력받은 정수들을 배열 i에 저장
            arr[i] = in.nextInt();
        }

        int result = search(arr, N, M); // search 메소드를 사용 3개의 매개변수 전달, result에 저장
        System.out.println(result); // result 출력
    }


    // 탐색
    static int search(int[] arr, int N, int M) {
        int result = 0; // result 값 초기화

        // 3개를 고르기 때문에 첫번째 카드는 N - 2 까지만 순회
        for (int i = 0; i < N - 2; i++) {

            // 두 번째 카드는 첫 번째 카드 다음부터 N - 1 까지만 순회
            for (int j = i + 1; j < N - 1; j++) {

                // 세 번째 카드는 두 번째 카드 다음부터 N 까지 순회
                for (int k = j + 1; k < N; k++) {

                    // 3개 카드의 합 임시변수 temp
                    int temp = arr[i] + arr[j] + arr[k];

                    // M과 세 카드의 합이 같다면 temp return 및 종료
                    if (M == temp) { // 5+7+9에서 반환
                        return temp;
                    }

                    // 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신
                    if(result < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }

        // 모든 순회를 마치면 result 리턴
        return result;
    }
}