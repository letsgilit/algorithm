package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1063_King {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        boolean[][] chessboard = new boolean[8][8];

        int kcol = arr[0].charAt(0) - 65;
        int krow = (arr[0].charAt(1) - 48) -1;

        int rcol = arr[1].charAt(0) - 65;
        int rrow = (arr[1].charAt(1) - 48) -1;

        int N = Integer.parseInt(arr[2]);

        chessboard[rrow][rcol] = true;
        chessboard[krow][kcol] = true;

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            int rowdir = 0;
            int coldir = 0;
            switch(cmd){
                case "R":
                    coldir =1;
                    break;
                case "L":
                    coldir =-1;
                    break;
                case "B":
                    rowdir =-1;
                    break;
                case "T":
                    rowdir =1;
                    break;
                case "RT":
                    coldir =1;
                    rowdir =1;
                    break;
                case "LT":
                    coldir =-1;
                    rowdir =1;
                    break;
                case "RB":
                    coldir =1;
                    rowdir =-1;
                    break;
                case "LB":
                    coldir =-1;
                    rowdir =-1;
                    break;
            }
            if(krow +rowdir < 8 && kcol +coldir < 8 && krow +rowdir >= 0 && kcol +coldir >= 0){
                if(chessboard[krow +rowdir][kcol +coldir]){
                    if(rrow +rowdir < 8 && rcol +coldir < 8 && rrow +rowdir >= 0 && rcol +coldir >= 0){
                        chessboard[rrow][rcol] = false;
                        chessboard[rrow +rowdir][rcol +coldir] = true;
                        rrow = rrow +rowdir;
                        rcol = rcol +coldir;

                        chessboard[krow][kcol] = false;
                        chessboard[krow +rowdir][kcol +coldir] = true;
                        krow = krow +rowdir;
                        kcol = kcol +coldir;
                    }
                }else{
                    chessboard[krow][kcol] = false;
                    chessboard[krow +rowdir][kcol +coldir] = true;
                    krow = krow +rowdir;
                    kcol = kcol +coldir;
                }
            }
        }
        System.out.println((char)(kcol + 65)+""+(krow +1));
        System.out.println((char)(rcol + 65)+""+(rrow +1));
    }
}
