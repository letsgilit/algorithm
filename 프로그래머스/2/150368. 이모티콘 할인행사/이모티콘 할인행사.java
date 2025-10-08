import java.util.*;

class Solution {
    int[][] users;
    int[] emoticons;
    int[] RATES = {10, 20, 30, 40};
    int[] selected; 

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
        if (depth == emoticons.length) {
            process();
            return;
        }

        for (int r : RATES) {
            selected[depth] = r;
            dfs(depth + 1);
        }
    }

    private void process() {
        int plusCount = 0;
        int salesSum = 0;

        for (int[] user : users) {
            int minRate = user[0];   
            int minPrice = user[1]; 

            int total = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (selected[i] >= minRate) {
                    total += emoticons[i] * (100 - selected[i]) / 100;
                }
            }

            if (total >= minPrice) {
                plusCount++;      
            } else {
                salesSum += total; 
            }
        }

        if (plusCount > maxPlus || (plusCount == maxPlus && salesSum > maxSales)) {
            maxPlus = plusCount;
            maxSales = salesSum;
        }
    }
}
