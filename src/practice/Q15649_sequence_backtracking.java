package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15649_sequence_backtracking {
    static int N;
    static int M;
    static int[] ans;
    static int[] arr;
    static int temp;
    static StringBuilder sb;
    public static void dfs(int depth){
        if(depth == M){
            for (int i = 0; i < ans.length; i++) {
                sb.append(ans[i]+" ");
            }
            sb.append('\n');
            return;
        }
        for (int i : arr) {
            if(temp <= i){
                temp = i;
                ans[depth]= i;
                dfs(depth+1);
                temp = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = input[0];
        M = input[1];
        arr = new int[N];
        ans = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);
    }
}
