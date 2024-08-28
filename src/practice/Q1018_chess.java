package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1018_chess {
    public static int getCount(int startrow, int startcol, String[] board){
        String[] orgboard = {"WBWBWBWB", "BWBWBWBW"};
        int whitecol = 0;
        for (int i = 0; i < 8; i++) {
            int row = startrow + i;
            for (int j = 0; j < 8; j++) {
                int col = startcol + j;
                if (board[row].charAt(col) != orgboard[row % 2].charAt(j)) whitecol++;
            }
        }
        return Math.min(whitecol , 64- whitecol);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = arr[0];
        int col = arr[1];

        String[] board = new String[col];

        for (int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }

        int target = Integer.MAX_VALUE;
        for (int i = 0; i <= row -8; i++) {
            for (int j = 0; j <= col -8; j++) {
                int newTarget = getCount(i,j,board);
                if(newTarget < target) target = newTarget;
            }
        }
        System.out.println(target);
    }
}
