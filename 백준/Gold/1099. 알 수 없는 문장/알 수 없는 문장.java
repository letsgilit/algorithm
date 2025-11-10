import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static String s;
  static String[] dict;
  static int n;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
    n = Integer.parseInt(br.readLine());
    dict = new String[n];
    for (int i = 0; i < n; i++) {
      dict[i] = br.readLine();
    }

    dp = new int[s.length() + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        String sub = s.substring(j, i);
        for (String word : dict) {
          int cost = getCost(sub, word);
          if (cost != -1 && dp[j] != Integer.MAX_VALUE) {
            dp[i] = Math.min(dp[i], dp[j] + cost);
          }
        }
      }
    }

    System.out.println(dp[s.length()] == Integer.MAX_VALUE ? -1 : dp[s.length()]);
  }

  static int getCost(String a, String b) {
    if (a.length() != b.length()) return -1;
    int[] ca = new int[26];
    int[] cb = new int[26];
    for (char c : a.toCharArray()) ca[c - 'a']++;
    for (char c : b.toCharArray()) cb[c - 'a']++;
    if (!Arrays.equals(ca, cb)) return -1;
    int diff = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) diff++;
    }
    return diff;
  }
}
