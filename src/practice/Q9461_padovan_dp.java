package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461_padovan_dp {
    public static long getans(int num){
        long ans = 0;
        long[] dp = new long[num +1];
        if(num == 1) ans = 1;
        if(num > 6){
            dp[2]=1;
            dp[3]=1;
            dp[4]=2;
            dp[5]=2;
            dp[6]=3;
            for (int j = 7; j <= num; j++) {
                dp[j] = dp[j-1]+dp[j-5];
            }
            ans = dp[num];
        }else if(num > 1){
            ans = num/2;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] arr = new int[input];
        for (int i = 0; i < input; i++) {
            System.out.println(getans(Integer.parseInt(br.readLine())));
        }

    }
}
