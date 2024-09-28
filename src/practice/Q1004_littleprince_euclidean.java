package practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1004_littleprince_euclidean {
    static int startX, startY, endX, endY;

    public static boolean ispass(int x, int y, int r){
        boolean chkStart = (startX - x) * (startX - x) + (startY - y) * (startY - y) < r * r;
        boolean chkEnd = (endX - x) * (endX - x) + (endY - y) * (endY - y) < r * r;

        return chkStart ^ chkEnd;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());


            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if(ispass(x,y,r)) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
