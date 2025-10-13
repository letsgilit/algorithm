import java.util.*;
class Solution {

	public int solution(int[] mats, String[][] park) {
		int rows = park.length;
		int cols = park[0].length;

		Arrays.sort(mats);

		for (int idx = mats.length - 1; idx >= 0; idx--) {
			int k = mats[idx];

			// 가능한 시작점 범위: i ≤ rows - k, j ≤ cols - k
			for (int i = 0; i <= rows - k; i++) {
				for (int j = 0; j <= cols - k; j++) {
					boolean canPlace = true;

					// k x k 영역 내 모두 빈 자리인지 확인
					for (int x = i; x < i + k; x++) {
						for (int y = j; y < j + k; y++) {
							if (!park[x][y].equals("-1")) {
								canPlace = false;
								break;
							}
						}
						if (!canPlace) break;
					}

					// 놓을 수 있으면 바로 리턴
					if (canPlace) {
						return k;
					}
				}
			}
		}

		// 아무 것도 놓지 못하면 -1
		return -1;
	}
}