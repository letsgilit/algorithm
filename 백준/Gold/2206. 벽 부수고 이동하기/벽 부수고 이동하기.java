import java.io.*;
import java.util.*;

public class Main {
  static int[][] map;
  static int[] dx = {0,0,1,-1};
  static int[] dy = {1,-1,0,0};
  static int N,M;
  static int answer;
  static boolean[][][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N+1][M+1];
    visited = new boolean[N+1][M+1][2];
    answer = Integer.MAX_VALUE;
    for (int i = 1; i <= N; i++) {
      char[] charArray = br.readLine().toCharArray();
      for (int j = 1; j <= M; j++) {
        map[i][j]= charArray[j-1] - '0';
      }
    }

    bfs();
    if (answer == Integer.MAX_VALUE) {
      System.out.println(-1);
    }else{
      System.out.println(answer);
    }

  }

  public static void bfs(){
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{1,1,1,1});
    visited[1][1][1] = true;

    while(!q.isEmpty()){
      int[] cur = q.poll();

      if(cur[0] == N && cur[1] == M) {
        answer = cur[2];
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + cur[0];
        int ny = dy[i] + cur[1];

        if(nx < 1|| nx > N || ny < 1|| ny > M) continue;

        int breakLimit = cur[3];
        if(map[nx][ny] == 1) {
          if(breakLimit == 0) continue;
          breakLimit = 0;
        }

        if (visited[nx][ny][breakLimit]) continue;
        visited[nx][ny][breakLimit] = true;

        q.add(new int[]{nx,ny,cur[2]+1,breakLimit});
      }
    }

  }
}
