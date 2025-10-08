import java.util.*;

class Solution {
    int[][] users;
    int[] emoticons;

    // 할인율을 정수(퍼센트)로 저장: 10,20,30,40
    final int[] RATES = {10, 20, 30, 40};
    int[] selected; // 각 이모티콘에 적용된 할인율(정수, %)

    int maxPlus = 0;
    int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.selected = new int[emoticons.length];

        dfs(0);
        return new int[] { maxPlus, maxSales };
    }

    private void dfs(int depth) {
        // 모든 이모티콘에 대해 할인율을 정하면 계산
        if (depth == emoticons.length) {
            process();
            return;
        }

        // 각 이모티콘에 대해 4가지 할인율을 시도
        for (int r : RATES) {
            selected[depth] = r;
            dfs(depth + 1);
        }
    }

    private void process() {
        int plusCount = 0;
        int salesSum = 0;

        for (int[] user : users) {
            int minRate = user[0];   // 사용자가 원하는 최소 할인율 (%)
            int minPrice = user[1];  // 이모티콘 플러스 가입 기준 금액

            int total = 0;
            for (int i = 0; i < emoticons.length; i++) {
                // 사용자가 요구하는 할인율 이상이면 구매
                if (selected[i] >= minRate) {
                    // 정수 연산으로 할인 가격 계산 (소수 오차 제거)
                    total += emoticons[i] * (100 - selected[i]) / 100;
                }
            }

            if (total >= minPrice) {
                plusCount++;      // 플러스 가입 (매출에 포함 X)
            } else {
                salesSum += total; // 일반 구매 매출
            }
        }

        // 플러스 가입자 수 우선 최대화, 동률이면 매출 최대화
        if (plusCount > maxPlus || (plusCount == maxPlus && salesSum > maxSales)) {
            maxPlus = plusCount;
            maxSales = salesSum;
        }
    }

    // (테스트용) 메인 예시
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        System.out.println(Arrays.toString(s.solution(users, emoticons))); // 예시 출력
    }
}
