import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<int[]> list = new ArrayList<>(N);

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int min = Integer.parseInt(st.nextToken());
      int max = Integer.parseInt(st.nextToken());
      list.add(new int[]{min, max});
    }
    dp = new int[201][N];
    int start = list.get(0)[0];
    int end = list.get(0)[1];

    for (int i = start; i <= end; i++) {
      dp[i][0] = i;
      for (int j = 1; j < list.size(); j++) {
        int[] range = list.get(j);
        dp[i][j] = getStress(i, j, range[0], range[1]);
      }
    }

    long min = Long.MAX_VALUE;
    int minIdx = 0;
    for (int i = start; i <= end; i++) {
      long sum = 0;
      for (int j = 0; j < N - 1; j++) {
        int n = Math.abs(dp[i][j] - dp[i][j+1]);
        sum += n;
      }
      if(sum < min){
        minIdx = i;
        min = sum;
      }
    }

    System.out.println(min);
    for (int n : dp[minIdx]) {
      System.out.println(n);
    }
  }

  public static int getStress(int idx, int jdx, int stressMin, int stressMax){
    int min = Integer.MAX_VALUE;
    int stress = 0;
    for (int i = stressMin; i <= stressMax; i++) {
      int sub = Math.abs(i - dp[idx][jdx-1]);
      if(sub < min){
        min = sub;
        stress = i;
      }
    }
    return stress;
  }
}
