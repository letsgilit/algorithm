import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

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
            int last = LIS.get(LIS.size() - 1);

            if (last < key) {
                LIS.add(key);
                markIndex[i] = LIS.size() - 1;
            } else {
                int idx = binarySearch(key);
                markIndex[i] = idx;
                LIS.set(idx, key);
            }
        }

        int startIdx = markIndex.length - 1;
        int[] answer = new int[LIS.size()];

        for (int i = LIS.size() - 1; i >= 0; i--) {
            for (int j = startIdx; j >= 0; j--) {
                if (i == markIndex[j]) {
                    startIdx = j;
                    answer[i] = arr[j];
                    break;
                }
            }
        }

        sb.append(LIS.size()).append("\n");
        for (int i : answer) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static int binarySearch(int key) {
        int lo = 0;
        int hi = LIS.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (LIS.get(mid) >= key)
                hi = mid;
            else
                lo = mid + 1;
        }
        return hi;
    }
}
