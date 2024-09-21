package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095_123Plus_dp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int j = 4; j < 11; j++) {
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
        }
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }

    }
}