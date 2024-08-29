package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Q1021_Linkedlist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = arr[0];
        int M = arr[1];

        LinkedList<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        int[] arr2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int ans = 0;
        for (int target : arr2) {
            int cnt = 0;
            if(que.size() / 2 >= que.indexOf(target)){
                while(que.peek() != target){
                    que.offerLast(que.pollFirst());
                    cnt++;
                }
            }else{
                while(que.peek() != target){
                    que.offerFirst(que.pollLast());
                    cnt++;
                }
            }
            que.poll();
            ans += cnt;
        }
        System.out.println(ans);
    }
}
