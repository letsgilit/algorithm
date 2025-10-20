import java.io.*;

public class Main {
  static final int MOD = 1_000_000_000;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][][] dp = new int[N + 1][10][1 << 10];

    for (int i = 1; i <= 9; i++) {
      dp[1][i][1 << i] = 1;
    }

    for (int len = 2; len <= N; len++) {
      for (int last = 0; last <= 9; last++) {
        for (int mask = 0; mask < (1 << 10); mask++) {
          int bit = mask | (1 << last);
          if (last > 0)
            dp[len][last][bit] = (dp[len][last][bit] + dp[len - 1][last - 1][mask]) % MOD;
          if (last < 9)
            dp[len][last][bit] = (dp[len][last][bit] + dp[len - 1][last + 1][mask]) % MOD;
        }
      }
    }

    long result = 0;
    int fullMask = (1 << 10) - 1;
    for (int i = 0; i <= 9; i++) {
      result = (result + dp[N][i][fullMask]) % MOD;
    }

    System.out.println(result);

  }
}
