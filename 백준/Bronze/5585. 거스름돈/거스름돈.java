import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] coinType = {500, 100, 50, 10, 5, 1}; // 동전 종류
        int pay = sc.nextInt(); // 지불 금액 입력받기
        int change = 1000 - pay; // 거스름돈 계산

        int coinNum = 0; // 동전의 갯수
        for (int i = 0; i < coinType.length; i++) // 동전 큰 가치부터 하나씩
        {
            coinNum += change / coinType[i]; // 거스름돈 / 동전 종류의 몫 -> 갯수에 +
            change %= coinType[i]; // 나머지 거스름돈 저장
        }
        System.out.print(coinNum); // 총 사용 동전 갯수 출력
    }
}