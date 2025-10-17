class Solution {
	public int solution(int[][] board, int[][] skill) {
		int n = board.length;
		int m = board[0].length;
		int[][] sum = new int[n + 1][m + 1];

		for (int[] s : skill) {
			int type = s[0];
			int r1 = s[1];
			int c1 = s[2];
			int r2 = s[3];
			int c2 = s[4];
			int degree = s[5];
			int value = (type == 1 ? -degree : degree); // 공격이면 -, 회복이면 +

			sum[r1][c1] += value;
			sum[r1][c2 + 1] -= value;
			sum[r2 + 1][c1] -= value;
			sum[r2 + 1][c2 + 1] += value;
		}

		// 가로 누적합
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				sum[i][j] += sum[i][j - 1];
			}
		}

		// 세로 누적합
		for (int j = 0; j < m; j++) {
			for (int i = 1; i < n; i++) {
				sum[i][j] += sum[i - 1][j];
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] + sum[i][j] > 0) {
					answer++;
				}
			}
		}
		return answer;
	}
}