package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501_dfs_quit {
    static int N;
    static int[][] arr;
    static int sum;
    static int day;

    public static void dfs(int day, int pay){
        if(day >= N+1) {
            sum = Math.max(pay, sum);
            return;
        }
        if(day + arr[day][0] <= N+1) {
            dfs(day + arr[day][0], pay + arr[day][1]);
        } else {
            dfs(day + arr[day][0], pay);
        }
        dfs(day + 1, pay);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        sum = 0;
        day = 0;

        dfs(1,0);

        System.out.println(sum);
    }
}
