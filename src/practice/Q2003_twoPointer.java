package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2003_twoPointer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int i = 0;
        int j = 0;
        int cnt = 0;
        while(true){
            if(sum >= M){
                sum -= arr[i++];
            }else if(j == N){
                break;
            } else{
                sum += arr[j++];
            }
            if(sum == M) cnt++;
        }
        System.out.println(cnt);
    }
}
