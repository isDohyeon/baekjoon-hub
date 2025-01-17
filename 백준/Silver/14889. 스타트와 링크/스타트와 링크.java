//package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] S;
    private static int powerGap = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] startTeam = new boolean[N];
        findMinPowerGap(startTeam, 0, 0);
        bw.write(String.valueOf(powerGap));
        bw.close();
    }

    private static void findMinPowerGap(boolean[] startTeam, int number, int depth) {
        if (depth >= N / 2) {
            calculateTeamGap(startTeam);
            return;
        }

        for (int i = number; i < N; i++) {
            if (!startTeam[i]) {
                startTeam[i] = true;
                findMinPowerGap(startTeam, i + 1, depth + 1);
                startTeam[i] = false;
            }
        }
    }

    private static void calculateTeamGap(boolean[] startTeam) {
        int startTeamPower = 0;
        int linkTeamPower = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (startTeam[i] && startTeam[j]) {
                    startTeamPower += S[i][j];
                } else if (!startTeam[i] && !startTeam[j]) {
                    linkTeamPower += S[i][j];
                }
            }
        }
        int gap = Math.abs(startTeamPower - linkTeamPower);
        powerGap = Math.min(powerGap, gap);
    }
}
