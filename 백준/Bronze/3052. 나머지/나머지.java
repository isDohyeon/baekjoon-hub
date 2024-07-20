import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = 10;
        int[] arr = new int[length];
        int count = length;
        int index = 0;
        boolean countZero = false;

        // 10번 반복
        for (int i = 0; i < length; i++) {
            // 입력받고 42로 나누기
            int remainder = sc.nextInt() % 42;

            // 저장된 값들이랑 비교
            for (int j = 0; j <= index; j++) {
                // 만약 저장된 값이랑 나머지가 같다면
                if (arr[j] == remainder) {
                    //System.out.println("현재 j : " + j + "arr[j] = " + arr[j] + ", 나머지 : " + remainder);
                    // 단, 나머지가 0일 경우 - 한 번만 셈
                    if (remainder == 0) {
                        countZero = true;
                    }
                    // 나머지가 저장된 값과 같지만 0이 아니라면 카운트 -1
                    count--;
                    //System.out.println("같은 나머지 : " + remainder + ", 현재 카운트 : " + count);
                    break;
                } else if (j == index) { // 만약 j까지 검사했는데 모두 달랐다면
                    // 인덱스 값에 나머지 저장 후 인덱스 증가
                    arr[index] = remainder;
                    //System.out.println("저장된 인덱스 : " + index + ", 저장된 값 : " + remainder);
                    index++;
                    break;
                }
            }
        }
        // 0 카운트가 한 번 이상이라면 +1, 아니라면 그대로 출력
        System.out.println(countZero ? count + 1 : count);

//        삼항 연산자 사용 - 밑의 if 문과 같음
//        if (countZero) { - countZero 가 true 라면
//            System.out.println(count + 1);
//        } else {
//            System.out.println(count);
//        }
    }
}