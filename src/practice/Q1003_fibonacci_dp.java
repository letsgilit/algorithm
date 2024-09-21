package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003_fibonacci_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[42];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= 41; i++) {
            dp[i]= dp[i-1] + dp[i-2];
        }
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]+" "+ dp[num+1]);
        }
    }
}
