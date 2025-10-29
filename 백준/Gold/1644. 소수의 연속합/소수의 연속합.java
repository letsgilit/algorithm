import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws  IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> primeList = new ArrayList<>();

    primeList.add(2);

    for(int i = 3; i <= n; i+=2){
      if(isPrime(i)){
        primeList.add(i);
      }
    }

    int left = 0;
    int right = 0;
    int count =0;
    int sum = 0;

    while(true){
      if(sum >= n){
        if(sum==n) count++;
        sum -= primeList.get(left++);
      }else{
        if(right == primeList.size()) break;
        sum += primeList.get(right++);
      }
    }

    System.out.println(count);

  }

  public static boolean isPrime(int n){
    for(int i = 2; i*i <= n; i++){
      if(n%i == 0) return false;
    }
    return true;
  }

}
