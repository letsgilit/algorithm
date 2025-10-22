import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    System.out.println(sol(B) - sol(A - 1));
  }

  public static long sol(long N) {
    N += 1;
    long cnt = 0;
    long size = 1;

    while (size < N) {
      size <<= 1;
    }

    while (size >= 2) {
      cnt += (N / size) * (size / 2);
      if ((N / (size / 2)) % 2 == 1) {
        cnt += N % (size / 2);
      }
      size /= 2;
    }
    return cnt;
  }
}
