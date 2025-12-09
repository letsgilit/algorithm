import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int V, E;
  static List<Node>[] graph;
  static int INF = Integer.MAX_VALUE;

  static class Node {

    int to, weight;

    public Node(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    int start = Integer.parseInt(br.readLine());

    graph = new List[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();

    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph[a].add(new Node(b, weight));
    }
    int[] dist = dijkstra(start);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < dist.length; i++) {
      if (dist[i] == INF)
        sb.append("INF").append("\n");
      else
        sb.append(dist[i]).append("\n");
    }
    System.out.println(sb);
  }

  public static int[] dijkstra(int start) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    int[] dist = new int[V + 1];
    Arrays.fill(dist, INF);
    boolean[] visited = new boolean[V + 1];
    pq.add(new int[]{start, 0});
    dist[start] = 0;

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int idx = cur[0];

      if (visited[idx])
        continue;
      visited[idx] = true;

      for (Node node : graph[idx]) {
        int u = node.to, w = node.weight;
        if (!visited[u] && dist[idx] + w < dist[u]) {
          dist[u] = dist[idx] + w;
          pq.add(new int[]{u, dist[u]});
        }
      }
    }
    return dist;
  }

}
