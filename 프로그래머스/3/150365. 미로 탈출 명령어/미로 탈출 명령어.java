class Solution {
	int n, m, r, c, k;
	int[] dr = {1, 0, 0, -1};
	int[] dc = {0, -1, 1, 0};
	char[] dir = {'d', 'l', 'r', 'u'};
	boolean found = false;
	String answer = "impossible";

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		this.r = r;
		this.c = c;
		this.n = n;
		this.m = m;
		this.k = k;

		found = false;
		answer = "impossible";

		int minDist = Math.abs(r - x) + Math.abs(c - y);
		if (minDist > k || (k - minDist) % 2 != 0) return "impossible";

		dfs(x,y,0, new StringBuilder());
		return answer;
	}

	public void dfs(int x, int y, int cnt, StringBuilder sb) {
		if (found) return;
		if (cnt == k) {
			if (x == r && y == c) {
				answer = sb.toString();
				found = true;
			}
			return;
		}

		int remain = k - cnt;
		int dist = Math.abs(r - x) + Math.abs(c - y);
		if (dist > remain) return;

		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

			sb.append(dir[i]);
			dfs(nx, ny, cnt + 1, sb);
			sb.deleteCharAt(sb.length() - 1);

			if (found) return;
		}
	}

}