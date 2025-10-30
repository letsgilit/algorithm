import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static class State {
    int rx, ry, bx, by, depth;
    State(int rx, int ry, int bx, int by, int depth) {
      this.rx = rx; this.ry = ry;
      this.bx = bx; this.by = by;
      this.depth = depth;
    }
  }

  static int N, M;
  static char[][] map;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int[] startR;
  static int[] startB;
  static boolean[][][][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];
    startR = new int[2];
    startB = new int[2];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      char[] arr = str.toCharArray();
      for (int j = 0; j < M; j++) {
        char info = arr[j];
        map[i][j] = info;
        if (info == 'R') startR = new int[]{i, j};
        if (info == 'B') startB = new int[]{i, j};
      }
    }

    visited = new boolean[N][M][N][M]; // 실제 상태 추적용

    System.out.println(bfs());
  }

  static int[] move(int x, int y, int dir) {
    int cnt = 0;
    while (true) {
      int nx = x + dx[dir];
      int ny = y + dy[dir];
      if (map[nx][ny] == '#') break;
      x = nx; y = ny; cnt++;
      if (map[x][y] == 'O') return new int[]{x, y, cnt, 1};
    }
    return new int[]{x, y, cnt, 0};
  }

  static int bfs() {
    Queue<State> q = new LinkedList<>();
    q.add(new State(startR[0], startR[1], startB[0], startB[1], 0));
    visited[startR[0]][startR[1]][startB[0]][startB[1]] = true;

    while (!q.isEmpty()) {
      State cur = q.poll();
      if (cur.depth >= 10) continue;

      for (int dir = 0; dir < 4; dir++) {
        int[] rMove = move(cur.rx, cur.ry, dir);
        int[] bMove = move(cur.bx, cur.by, dir);

        if (bMove[3] == 1) continue;
        if (rMove[3] == 1) return cur.depth + 1;

        int nrx = rMove[0], nry = rMove[1];
        int nbx = bMove[0], nby = bMove[1];

        if (nrx == nbx && nry == nby) {
          if (rMove[2] > bMove[2]) {
            nrx -= dx[dir];
            nry -= dy[dir];
          } else {
            nbx -= dx[dir];
            nby -= dy[dir];
          }
        }

        if (!visited[nrx][nry][nbx][nby]) {
          visited[nrx][nry][nbx][nby] = true;
          q.add(new State(nrx, nry, nbx, nby, cur.depth + 1));
        }
      }
    }
    return -1;
  }
}
