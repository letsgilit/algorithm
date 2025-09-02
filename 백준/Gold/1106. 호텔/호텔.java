import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int C = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    int maxCustomer = C + 100;
    int[] dp = new int[maxCustomer + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= maxCustomer; i++) {
      for (int j = 0; j < N; j++) {
        if (i - arr[j][1] >= 0 && dp[i - arr[j][1]] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - arr[j][1]] + arr[j][0]);
        }
      }
    }

    int answer = Integer.MAX_VALUE;
    for (int i = C; i <= maxCustomer; i++) {
      answer = Math.min(answer, dp[i]);
    }
    System.out.println(answer);
  }
}
