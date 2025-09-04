import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] a = br.readLine().toCharArray();
    char[] b = br.readLine().toCharArray();

    int[][] dp = new int[a.length + 1][b.length + 1];

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        if (a[i - 1] == b[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    System.out.println(dp[a.length][b.length]);

    StringBuilder lcs = new StringBuilder();
    int i = a.length, j = b.length;
    while (i > 0 && j > 0) {
      if (a[i - 1] == b[j - 1]) { 
        lcs.append(a[i - 1]);
        i--;
        j--;
      } else if (dp[i - 1][j] >= dp[i][j - 1]) {
        i--; 
      } else {
        j--; 
      }
    }

   
    System.out.println(lcs.reverse());
  }
}
