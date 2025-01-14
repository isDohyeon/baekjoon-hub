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
            int lastDayStock = -1;
            for (int i = 0; i < 14; i++) {
                int todayStock = Integer.parseInt(st.nextToken());
                if (lastDayStock != -1) {
                    updateStreak(todayStock, lastDayStock);
                }
                handleTrade(todayStock, junhyeon, seongmin);
                lastDayStock = todayStock;
            }

            int jhAssets = junhyeon.getTotalAssets(lastDayStock);
            int smAssets = seongmin.getTotalAssets(lastDayStock);
            bw.write(configWinner(jhAssets, smAssets));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateStreak(int todayStock, int lastDayStock) {
        if (todayStock > lastDayStock) {
            risingStreak++;
            fallingStreak = 0; 
            return;
        }
        if (todayStock < lastDayStock) { 
            fallingStreak++;
            risingStreak = 0; 
            return;
        }
        risingStreak = 0;
        fallingStreak = 0;
    }

    private static String configWinner(int jhAssets, int smAssets) {
        if (jhAssets > smAssets) {
            return "BNP";
        }
        if (jhAssets < smAssets) {
            return "TIMING";
        }
        return "SAMESAME";
    }

    private static void handleTrade(int stockValue, Trader junhyeon, Trader seongmin) {
        if (junhyeon.getCash() >= stockValue) {
            junhyeon.buy(stockValue);
        }
        if (fallingStreak >= 3 && seongmin.getCash() >= stockValue) {
            seongmin.buy(stockValue);
        }
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
        int buyAmount = cash / stockValue; 
        cash -= buyAmount * stockValue;
        shares += buyAmount;        
    }

    public void sell(int stockValue) {
        cash += shares * stockValue; 
        shares = 0;                 
    }

    public int getCash() {
        return cash;
    }

    public int getTotalAssets(int stockValue) {
        return cash + (shares * stockValue); 
    }
}
