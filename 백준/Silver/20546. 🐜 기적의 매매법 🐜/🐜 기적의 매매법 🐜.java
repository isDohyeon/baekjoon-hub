//package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int risingStreak = 0;
    private static int fallingStreak = 0;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int cash = Integer.parseInt(br.readLine());
            Trader junhyeon = new Trader(cash);
            Trader seongmin = new Trader(cash);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int lastDayStock = -1; // 첫날 비교를 위해 초기값을 -1로 설정
            
            for (int i = 0; i < 14; i++) {
                int todayStock = Integer.parseInt(st.nextToken());

                // 첫날은 streak 계산하지 않음
                if (lastDayStock != -1) {
                    updateStreak(todayStock, lastDayStock);
                }

                handleTrade(todayStock, junhyeon, seongmin);
                lastDayStock = todayStock; // 현재 주가를 이전 주가로 갱신
            }

            int jhAssets = junhyeon.getTotalAssets(lastDayStock);
            int smAssets = seongmin.getTotalAssets(lastDayStock);
            bw.write(configWinner(jhAssets, smAssets) + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateStreak(int todayStock, int lastDayStock) {
        if (todayStock > lastDayStock) { // 주가 상승
            risingStreak++;
            fallingStreak = 0; // 상승 시 하락 연속 초기화
        } else if (todayStock < lastDayStock) { // 주가 하락
            fallingStreak++;
            risingStreak = 0; // 하락 시 상승 연속 초기화
        } else { // 주가 변동 없음
            risingStreak = 0;
            fallingStreak = 0;
        }
    }

    private static String configWinner(int jhAssets, int smAssets) {
        if (jhAssets > smAssets) {
            return "BNP";
        } else if (jhAssets < smAssets) {
            return "TIMING";
        } else {
            return "SAMESAME";
        }
    }

    private static void handleTrade(int stockValue, Trader junhyeon, Trader seongmin) {
        // 준현은 가능한 만큼 매수
        if (junhyeon.getCash() >= stockValue) {
            junhyeon.buy(stockValue);
        }

        // 성민은 3일 연속 하락 시 매수
        if (fallingStreak >= 3 && seongmin.getCash() >= stockValue) {
            seongmin.buy(stockValue);
        }

        // 성민은 3일 연속 상승 시 매도
        if (risingStreak >= 3) {
            seongmin.sell(stockValue);
        }
    }
}

class Trader {

    private int cash;
    private int shares;

    public Trader(int cash) {
        this.cash = cash;
        this.shares = 0;
    }

    public void buy(int stockValue) {
        int buyAmount = cash / stockValue; // 살 수 있는 최대 주식 수
        cash -= buyAmount * stockValue;   // 사용한 금액 차감
        shares += buyAmount;              // 주식 수 증가
    }

    public void sell(int stockValue) {
        cash += shares * stockValue;      // 주식 판매 후 현금 증가
        shares = 0;                       // 모든 주식 매도
    }

    public int getCash() {
        return cash;
    }

    public int getTotalAssets(int stockValue) {
        return cash + (shares * stockValue); // 현금 + 현재 주식 가치
    }
}