package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_dfs_bfs {
    static int N;
    static int M;
    static int V;
    static boolean[][] graph;
    static boolean[] visit;
    static StringBuilder sb;
    static Queue<Integer> que = new LinkedList<>();

    public static void dfs(int n){
        visit[n] = true;
        sb.append(n+" ");

        for (int i = 1; i < graph.length; i++) {
            if(!visit[i] && graph[n][i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int n){
        que.offer(n);
        visit[n] = true;

        while(!que.isEmpty()){
            int idx = que.poll();
            sb.append(idx+" ");

            for (int i = 1; i < graph.length; i++) {
                if(!visit[i] && graph[idx][i]){
                    visit[i] = true;
                    que.offer(i);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][N+1];
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = true;
        }

        dfs(V);

        visit = new boolean[N+1];
        sb.append("\n");

        bfs(V);

        System.out.println(sb);
    }
}