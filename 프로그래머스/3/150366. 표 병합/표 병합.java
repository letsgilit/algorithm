import java.util.*;
class Solution {
	private final int SIZE = 51;
	private String[][] map = new String[SIZE][SIZE]; 
	private int[][] parentR = new int[SIZE][SIZE];   
	private int[][] parentC = new int[SIZE][SIZE];  

	public Solution() {
		for (int i = 1; i < SIZE; i++) {
			for (int j = 1; j < SIZE; j++) {
				parentR[i][j] = i;
				parentC[i][j] = j;
			}
		}
	}

	public String[] solution(String[] commands) {
		List<String> answer = new ArrayList<>();

		for (String command : commands) {
			StringTokenizer st = new StringTokenizer(command);
			String type = st.nextToken();

			switch (type) {
				case "UPDATE":
					if (st.countTokens() == 3) {
						int r = Integer.parseInt(st.nextToken());
						int c = Integer.parseInt(st.nextToken());
						String value = st.nextToken();
						update(r, c, value);
					} else {
						String value1 = st.nextToken();
						String value2 = st.nextToken();
						update(value1, value2);
					}
					break;

				case "MERGE":
					int r1 = Integer.parseInt(st.nextToken());
					int c1 = Integer.parseInt(st.nextToken());
					int r2 = Integer.parseInt(st.nextToken());
					int c2 = Integer.parseInt(st.nextToken());
					merge(r1, c1, r2, c2);
					break;

				case "UNMERGE":
					int r = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					unmerge(r, c);
					break;

				case "PRINT":
					int row = Integer.parseInt(st.nextToken());
					int col = Integer.parseInt(st.nextToken());
					print(row, col, answer);
					break;
			}
		}

		return answer.toArray(new String[0]);
	}

	/** find: 셀의 대표(루트) 좌표 찾기 */
	private int[] find(int r, int c) {
		if (parentR[r][c] == r && parentC[r][c] == c)
			return new int[]{r, c};

		int[] root = find(parentR[r][c], parentC[r][c]);
		parentR[r][c] = root[0];
		parentC[r][c] = root[1];
		return root;
	}

	/** UPDATE r c value */
	private void update(int r, int c, String value) {
		int[] root = find(r, c);
		map[root[0]][root[1]] = value;
	}

	/** UPDATE value1 value2 */
	private void update(String value1, String value2) {
		for (int i = 1; i < SIZE; i++) {
			for (int j = 1; j < SIZE; j++) {
				if (map[i][j] != null && map[i][j].equals(value1)) {
					map[i][j] = value2;
				}
			}
		}
	}

	/** MERGE r1 c1 r2 c2 */
	private void merge(int r1, int c1, int r2, int c2) {
		int[] root1 = find(r1, c1);
		int[] root2 = find(r2, c2);

		if (root1[0] == root2[0] && root1[1] == root2[1])
			return; // 이미 같은 그룹

		String value1 = map[root1[0]][root1[1]];
		String value2 = map[root2[0]][root2[1]];
		String mergedValue = (value1 != null) ? value1 : value2;

		// root2를 root1으로 병합
		parentR[root2[0]][root2[1]] = root1[0];
		parentC[root2[0]][root2[1]] = root1[1];

		map[root1[0]][root1[1]] = mergedValue;
	}

	/** UNMERGE r c */
	private void unmerge(int r, int c) {
		int[] root = find(r, c);
		String savedValue = map[root[0]][root[1]];

		// 같은 그룹 모두 해제
		List<int[]> group = new ArrayList<>();
		for (int i = 1; i < SIZE; i++) {
			for (int j = 1; j < SIZE; j++) {
				int[] nowRoot = find(i, j);
				if (nowRoot[0] == root[0] && nowRoot[1] == root[1]) {
					group.add(new int[]{i, j});
				}
			}
		}

		// 그룹 해체
		for (int[] cell : group) {
			parentR[cell[0]][cell[1]] = cell[0];
			parentC[cell[0]][cell[1]] = cell[1];
			map[cell[0]][cell[1]] = null;
		}

		// 원래 셀만 값 복원
		map[r][c] = savedValue;
	}

	/** PRINT r c */
	private void print(int r, int c, List<String> answer) {
		int[] root = find(r, c);
		String value = map[root[0]][root[1]];
		answer.add(value == null ? "EMPTY" : value);
	}
}
