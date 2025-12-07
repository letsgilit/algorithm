import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Deque<Integer> deq = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    for (int i = 1; i <= N; i++) {
      deq.addLast(i);
    }

    while (!deq.isEmpty()) {
      for (int i = 0; i < K-1; i++) {
        deq.addLast(deq.pollFirst());
      }
      sb.append(deq.pollFirst());

      if (!deq.isEmpty()) {
        sb.append(", ");
      }

    }
    sb.append(">");
    System.out.println(sb);
  }

}
