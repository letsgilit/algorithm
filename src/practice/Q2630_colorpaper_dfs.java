package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2630_colorpaper_dfs {
    static int N;
    static boolean[][] paper;
    static int white;
    static int blue;

    public static void dfs(int row, int col, int size){
        int newSize = size/2;

        int[] range_x = {0,0, newSize, newSize};
        int[] range_y = {0, newSize,0, newSize};

        if(checkColor(row, col, size)){
            if(paper[row][col]){
                blue++;
            }else {
                white++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            dfs(range_x[i]+row,range_y[i]+col,newSize);
        }
    }
    public static boolean checkColor(int row, int col, int size){
        boolean allWhite = true;
        boolean allBlue = true;
        for (int i = row; i < row+size; i++) {
            for (int j = col; j <col+size ; j++) {
                if(paper[i][j]){
                    allWhite = false;
                }else {
                    allBlue = false;
                }
            }
        }
        return allWhite || allBlue;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        paper = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        dfs(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }
}