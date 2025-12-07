import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while(true){
      String s = br.readLine();
      if(s.equals("0")) break;
      boolean isPalindrome = true;
      double N = Math.floor((double) s.length() / 2);
      
      for (int i = 0; i < N; i++) {
        if(s.charAt(i) != s.charAt(s.length()-1 - i)){
          isPalindrome = false;
        }
      }
      if (isPalindrome)
        System.out.println("yes");
      else {
        System.out.println("no");
      }
    }
  }

}
