package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_11399_twoPointer_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        int sum = arr[left];
        int temp = 0;
        while(right < n){
            temp += arr[right-1];
            sum += temp+arr[right];
            right++;
        }
        System.out.println(sum);
    }
}
