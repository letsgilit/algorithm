package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463_dp_Make1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            System.out.println("i는"+i);
            dp[i] = dp[i-1] + 1;
            System.out.println("이건>?"+dp[i]);
            if(i % 2 == 0){
                System.out.println("2로진입 =>"+"dp i = "+dp[i]+"dp i/2 = "+dp[i/2]);
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i % 3 == 0){
                System.out.println("3로진입 =>"+"dp i = "+dp[i]+"dp i/3 = "+dp[i/3]);
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
