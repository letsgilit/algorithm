import java.util.*;

class Solution {
    int n;
    int[][] q;
    int[] ans;
    int count = 0;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;

        int[] comb = new int[5];
        dfs(1, 0, comb);

        return count;
    }

    public void dfs(int start, int depth, int comb[]){
        if(depth == 5){
            if(isValid(comb)){
                 count++;
            }
            return;
        }
        
        for(int i = start; i <=n ; i++){
            comb[depth] = i;
            dfs(i+1, depth+1, comb);    
        }
    }
    
    public boolean isValid(int[] comb){
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : comb) 
            set.add(n);
        
        for (int i = 0; i < q.length; i++) {
            int match = 0;
            for (int x : q[i]) {
                if (set.contains(x)) match++;
            }
            if (match != ans[i]) return false;
        }
        return true;
    }
}