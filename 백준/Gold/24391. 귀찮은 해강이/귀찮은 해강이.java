import java.io.*;
import java.util.*;

public class Main {

  static int[] parent;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    parent = new int[N+1];

    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      union(a,b);
    }

    int count = 0;
    st = new StringTokenizer(br.readLine());
    int cur = find(Integer.parseInt(st.nextToken()));

    while(st.hasMoreElements()){
      int next = find(Integer.parseInt(st.nextToken()));
      if(cur != next){
        count++;
      }
      cur = next;
    }
    
    System.out.println(count);
  }

  public static int find(int a){
    if(parent[a] != a){
      return parent[a] = find(parent[a]);
    }
    return a;
  }

  public static void union(int a, int b){
    a = find(a);
    b = find(b);
    if(a != b) parent[b] = a;
  }

}
