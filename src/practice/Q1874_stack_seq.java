package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q1874_stack_seq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sortedArr = Arrays.stream(arr).sorted().toArray();

        int popcnt = 0;
        int temp = 0;
        int pluscnt = 0;
        boolean isNo = false;
        
        while(popcnt < N){
            int target = arr[popcnt];

            if(target > temp){
                for (int i = pluscnt; i < N; i++) {
                    stack.push(sortedArr[i]);
                    sb.append("+\n");
                    pluscnt++;
                    if(sortedArr[i] == target){
                        break;
                    }
                }
            }

            if(stack.peek() == target){
                stack.pop();
                sb.append("-\n");
                popcnt++;
                temp = target;
            }else{
                isNo = true;
                break;
            }
        }
        if(isNo){
            System.out.println("NO");
        }else {
            System.out.println(sb);
        }
        
    }
}