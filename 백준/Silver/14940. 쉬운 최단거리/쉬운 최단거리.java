import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = {0,0,1,-1};
  static int[] dy = {1,-1,0,0};
  static int N,M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[N][M];
    int[] goal = new int[2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int info = Integer.parseInt(st.nextToken());
        if(info == 2){
          goal = new int[]{i,j};
        }
        map[i][j] = info;
      }
    }

    bfs(goal);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        boolean success = false;
        if(map[i][j] == 1){
          for (int k = 0; k < 4; k++) {
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(nx < 0|| nx >= N||ny < 0|| ny >= M) continue;
            if(map[nx][ny] == 2) success = true;
          }
          if(!success) sb.append(-1).append(" ");
          else sb.append(map[i][j]).append(" ");
        }else{
          sb.append(map[i][j]).append(" ");
        }
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static void bfs(int[] start){
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{start[0],start[1],0});
    visited[start[0]][start[1]] = true;
    map[start[0]][start[1]] = 0;
    while(!q.isEmpty()){
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];
      int time = cur[2];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx < 0|| nx >= N||ny < 0|| ny >= M) continue;
        if(visited[nx][ny]) continue;
        if(map[nx][ny] == 0) continue;

        visited[nx][ny] = true;
        map[nx][ny] = time + 1;
        q.add(new int[]{nx, ny, time + 1});

      }
    }
  }
}
