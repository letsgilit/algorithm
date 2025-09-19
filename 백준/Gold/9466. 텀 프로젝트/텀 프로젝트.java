import java.util.*;
import java.io.*;

public class Main{
  static int[] arr;
  static boolean[] visit, isTeam;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(bf.readLine());

    StringTokenizer st;
    while(T--> 0){
      int n = Integer.parseInt(bf.readLine());
      arr = new int[n+1];
      visit = new boolean[n+1];
      isTeam = new boolean[n+1];
      count = 0;

      st = new StringTokenizer(bf.readLine());

      for(int i=1; i<= n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }

      for(int i=1; i<= n; i++){
        if(!isTeam[i]){
          dfs(i);
        }
      }
      System.out.println(n-count);
    }
  }

  public static void dfs(int n){
    if(visit[n]){
      isTeam[n] = true;    // 팀 편성 완료했다고 처리
      count++;    // 팀 편성 완료 인원 증가
    }else{
      visit[n] = true;
    }

    if(!isTeam[arr[n]]){
      dfs(arr[n]);
    }

    visit[n] = false;
    isTeam[n] = true;
  }
}