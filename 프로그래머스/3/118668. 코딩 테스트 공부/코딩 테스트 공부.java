import java.util.*;
class Solution {
    class State implements Comparable<State> {
    int alp, cop, time;

    State(int alp, int cop, int time) {
        this.alp = alp;
        this.cop = cop;
        this.time = time;
    }

    @Override
    public int compareTo(State o) {
        return this.time - o.time; // 최소 시간 기준 정렬
    }
}
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        // 이미 충분하면 바로 0 리턴
        if (alp >= maxAlp && cop >= maxCop) return 0;

        // 방문 체크 (필요: 중복 방지)
        boolean[][] visited = new boolean[maxAlp + 2][maxCop + 2];
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(alp, cop, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int a = Math.min(cur.alp, maxAlp);
            int c = Math.min(cur.cop, maxCop);

            if (visited[a][c]) continue;
            visited[a][c] = true;

            if (a >= maxAlp && c >= maxCop) return cur.time;

            // 1️⃣ 공부로 능력치 올리기
            if (a + 1 <= maxAlp && !visited[a + 1][c])
                pq.offer(new State(a + 1, c, cur.time + 1));
            if (c + 1 <= maxCop && !visited[a][c + 1])
                pq.offer(new State(a, c + 1, cur.time + 1));

            // 2️⃣ 문제 풀기
            for (int[] p : problems) {
                if (a >= p[0] && c >= p[1]) {
                    int nextA = Math.min(maxAlp, a + p[2]);
                    int nextC = Math.min(maxCop, c + p[3]);
                    pq.offer(new State(nextA, nextC, cur.time + p[4]));
                }
            }
        }

        return -1; // 도달 불가한 경우
    }
}