import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] markIndex = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS = new ArrayList<>();
        LIS.add(arr[0]);
        markIndex[0] = 0;

        for (int i = 1; i < N; i++) {
            int key = arr[i];
            if (key > LIS.get(LIS.size() - 1)) {
                LIS.add(key);
                markIndex[i] = LIS.size() - 1;
            } else {
                int idx = binarySearch(key);
                markIndex[i] = idx;
                LIS.set(idx, key);
            }
        }

        System.out.println(LIS.size());

        int index = LIS.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (markIndex[i] == index) {
                index--;
                stack.push(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int binarySearch(int key) {
        int lo = 0, hi = LIS.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (LIS.get(mid) >= key) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }
}
