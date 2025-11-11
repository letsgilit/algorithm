import java.io.*;
import java.util.*;

public class Main {
  static class State {
    int x, y;
    boolean isFire;
    int time;

    public State(int x, int y, boolean isFire, int time) {
      this.x = x;
      this.y = y;
      this.isFire = isFire;
      this.time = time;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    char[][] map = new char[R][C];
    boolean[][] visited = new boolean[R][C];
    int[] jihoon = new int[2];
    List<int[]> fires = new ArrayList<>();

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    for (int i = 0; i < R; i++) {
      char[] line = br.readLine().toCharArray();
      for (int j = 0; j < C; j++) {
        map[i][j] = line[j];
        if (map[i][j] == 'J') jihoon = new int[]{i, j};
        if (map[i][j] == 'F') fires.add(new int[]{i, j});
      }
    }

    if (jihoon[0] == 0 || jihoon[0] == R - 1 || jihoon[1] == 0 || jihoon[1] == C - 1) {
      System.out.println(1);
      return;
    }

    Queue<State> q = new LinkedList<>();

    for (int[] f : fires) {
      q.add(new State(f[0], f[1], true, 0));
    }

    q.add(new State(jihoon[0], jihoon[1], false, 0));
    visited[jihoon[0]][jihoon[1]] = true;

    while (!q.isEmpty()) {
      State cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (!cur.isFire && (nx < 0 || nx >= R || ny < 0 || ny >= C)) {
          System.out.println(cur.time + 1);
          return;
        }

        if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
        if (cur.isFire) {
          if (map[nx][ny] == '.' || map[nx][ny] == 'J') {
            map[nx][ny] = 'F';
            q.add(new State(nx, ny, true, 0));
          }
        } else {
          if (visited[nx][ny]) continue;
          if (map[nx][ny] == '#' || map[nx][ny] == 'F') continue;

          visited[nx][ny] = true;
          map[nx][ny] = 'J';
          q.add(new State(nx, ny, false, cur.time + 1));
        }
      }
    }

    System.out.println("IMPOSSIBLE");
  }
}
