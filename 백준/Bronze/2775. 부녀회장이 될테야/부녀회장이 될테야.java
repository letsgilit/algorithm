import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while(T --> 0){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int[][] dp = new int[a+1][b+1];

            for (int i = 0; i <= a; i++) {
                for (int j = 1; j <= b; j++) {
                    dp[i][j] = j;
                }
            }

            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= b; j++) {
                    int sum = 0;
                    for (int k = 1; k <= j ; k++) {
                        sum += dp[i-1][k];
                    }
                    dp[i][j] = sum;
                }
            }
            System.out.println(dp[a][b]);
        }
    }
}