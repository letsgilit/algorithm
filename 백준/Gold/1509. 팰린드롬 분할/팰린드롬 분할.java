import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static boolean[][] palindrome;
  public static void main(String[] args) throws  IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int[] dp = new int[str.length()+1];
    makeTable(str);

    for (int i = 1; i <= str.length(); i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 1; j <= i; j++) {
        if (palindrome[j][i]) {
          dp[i] = Math.min(dp[i], dp[j - 1] + 1);
        }
      }
    }

    System.out.println(dp[str.length()]);
  }

  public static void makeTable(String str){
    palindrome = new boolean[str.length()+1][str.length()+1];

    for (int start = 1; start < palindrome.length ; start++) {
      for (int end = start; end < palindrome.length; end++) {
        boolean flag = true;

        int s = start - 1;
        int e = end - 1;
        while (s <= e) {
          if (str.charAt(s++) != str.charAt(e--)) {
            flag = false;
            break;
          }
        }
        if (flag) palindrome[start][end] = true;
      }
    }
  }
}
