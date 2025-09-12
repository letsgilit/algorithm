import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] cards,savedCards;
  static int[] P,S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    cards = new int[N];
    savedCards = new int[N];
    P = new int[N];
    S = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      P[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      S[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      cards[i] = i;
      savedCards[i] = i;
    }

    int cnt = 0;

    while (!isSuccess()) {
      cnt++;
      int[] shuffledCard = shuffledCard();
      if(Arrays.equals(savedCards, shuffledCard)){
        cnt = -1;
        break;
      }
      cards = shuffledCard;
    }

    System.out.println(cnt);
  }

  public static boolean isSuccess(){
    //매칭
    int[][] jinyoung = new int[N][2];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 2; j++) {
        if(j == 0){
          jinyoung[i][j] = cards[i];
        }else{
          jinyoung[i][j] = i % 3;
        }
      }
    }

    Arrays.sort(jinyoung, Comparator.comparingInt(a -> a[0]));

    // 검증
    for (int i = 0; i < N; i++) {
      if(P[i] != jinyoung[i][1]){
        return false;
      }
    }
    return true;
  }

  public static int[] shuffledCard(){
    int[] newCards = new int[N];
    for (int i = 0; i < N; i++) {
      newCards[S[i]] = cards[i];
    }
    return newCards;
  }
}
