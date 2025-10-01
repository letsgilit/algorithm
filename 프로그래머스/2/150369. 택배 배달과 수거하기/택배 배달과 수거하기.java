import java.util.*;
class Solution {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int[][] arr = new int[2][n];

		for (int i = 0; i < n; i++) {
			arr[0][i] = deliveries[i];
			arr[1][i] = pickups[i];
		}

		int start = n - 1;
		int pStart = n - 1;

		while (start >= 0 || pStart >= 0) {
			while (start >= 0 && arr[0][start] == 0) start--;
			while (pStart >= 0 && arr[1][pStart] == 0) pStart--;

			if (start < 0 && pStart < 0) break;

			int distance = Math.max(start, pStart) + 1;
			int amount = cap;

			for (int i = start; i >= 0 && amount > 0; i--) {
				if (arr[0][i] == 0) continue;
				if (arr[0][i] <= amount) {
					amount -= arr[0][i];
					arr[0][i] = 0;
				} else {
					arr[0][i] -= amount;
					amount = 0;
					start = i;
					break;
				}
				start = i;
			}

			amount = cap;
			for (int i = pStart; i >= 0 && amount > 0; i--) {
				if (arr[1][i] == 0) continue;
				if (arr[1][i] <= amount) {
					amount -= arr[1][i];
					arr[1][i] = 0;
				} else {
					arr[1][i] -= amount;
					amount = 0;
					pStart = i;
					break;
				}
				pStart = i;
			}

			answer += distance * 2L;
		}

		return answer;
	}
}