import java.util.*;
import java.io.*;

public class Main{
  static List<Integer> LIS;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    LIS = new ArrayList<>();
    LIS.add(arr[0]);

    for (int i = 1; i < N; i++) {
      int key = arr[i];
      int last = LIS.get(LIS.size() - 1);

      if (last < key)
        LIS.add(key);
      else
        LIS.set(binarySearch(LIS.size() -1, key), key);
    }

    System.out.println(LIS.size());
  }

  static int binarySearch(int size, int key){
    int low = 0;
    int high = size;
    while (low < high) {
      int mid = (low + high) / 2;

      if (LIS.get(mid) >= key)
        high = mid;
      else
        low = mid + 1;
    }
    return high;
  }

}