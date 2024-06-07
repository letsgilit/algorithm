package practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Q1764_HashsetCompare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int N = arr[0];
        int M = arr[1];
        String[] d = new String[N];
        String[] b = new String[M];
        HashSet<String> setD = new HashSet<>();
        HashSet<String> setB = new HashSet<>();
        for (int i = 0; i < N; i++) {
            setD.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            setB.add(br.readLine());
        }
        ArrayList<String> list = new ArrayList<>();
        for (String s : setD) {
            if(setB.contains(s)) list.add(s);
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
