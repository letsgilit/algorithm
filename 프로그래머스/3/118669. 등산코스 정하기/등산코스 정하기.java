import java.util.*;

class Solution {
    
    int n;
    List<Edge>[] graph;
    boolean[] isGate, isSummit;
    
    class Edge {
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        this.n = n;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] p : paths) {
            int a = p[0]; 
            int b = p[1];
            int c = p[2];
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        isGate = new boolean[n + 1];
        isSummit = new boolean[n + 1];
        for (int g : gates) isGate[g] = true;
        for (int s : summits) isSummit[s] = true;
        
        int[] intensity = bfs(gates);

        Arrays.sort(summits);
        
        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;
        
        for (int s : summits) {
            if (intensity[s] < minIntensity) {
                minIntensity = intensity[s];
                minSummit = s;
            }
        }

        return new int[]{minSummit, minIntensity};
    }

    public int[] bfs(int[] gates) {
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int g : gates) {
            intensity[g] = 0;
            pq.offer(new int[]{g, 0});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if (cost > intensity[node]) continue;
            if (isSummit[node]) continue; 

            for (Edge next : graph[node]) {
                if (isGate[next.to]) continue; 

                int newIntensity = Math.max(cost, next.cost);
                if (newIntensity < intensity[next.to]) {
                    intensity[next.to] = newIntensity;
                    pq.offer(new int[]{next.to, newIntensity});
                }
            }
        }

        return intensity;
    }
}
