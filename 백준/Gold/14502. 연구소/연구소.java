import java.util.*;

public class Main {
  static int n, m;
  static int[][] map;
  static int maxSafeArea = 0;

  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map[i][j] = sc.nextInt();
      }
    }

    buildWall(0);
    System.out.println(maxSafeArea);
  }

  static void buildWall(int count) {
    if (count == 3) {
      bfs();
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1; // 벽 설치
          buildWall(count + 1);
          map[i][j] = 0; // 복구
        }
      }
    }
  }

  static void bfs() {
    int[][] copy = new int[n][m];
    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        copy[i][j] = map[i][j];
        if (copy[i][j] == 2) {
          queue.add(new int[] {i, j});
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if (copy[nx][ny] == 0) {
            copy[nx][ny] = 2;
            queue.add(new int[]{nx, ny});
          }
        }
      }
    }

    int safe = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (copy[i][j] == 0) safe++;
      }
    }

    maxSafeArea = Math.max(maxSafeArea, safe);
  }
}
