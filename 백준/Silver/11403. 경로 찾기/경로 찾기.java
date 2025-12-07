import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static List<Integer>[] graph;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    graph = new List[N];
    int[][] ans = new int[N][N];
    visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int n = Integer.parseInt(st.nextToken());
        if(n == 1){
          graph[i].add(j);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        visited = new boolean[N];
        if(recur(i,j,0)){
          sb.append("1 ");
        }else{
          sb.append("0 ");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static boolean recur(int start, int end ,int count){
    if(count != 0 && start == end){
      return true;
    }

    for (Integer next : graph[start]) {
      if(visited[next]) continue;
      visited[next] = true;
      if(recur(next, end, count+1)) return true;
    }
    return false;
  }
}
