import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    long round = Math.round(N * 0.15);

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    for (int i = 0; i < round; i++) {
      arr[i] = 0;
      arr[(N-1) - i] = 0;
    }

    int sum = 0;

    for (int i : arr) {
      sum+=i;
    }
    int answer = Math.round((float) sum / (N - (round * 2)));
    System.out.println(answer);
  }

}
