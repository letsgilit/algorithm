package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class Q1012_dfs{
	static int[][] arr;
	static int[][] check; 
	static int each;
	static int n1;
	static int n2;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			n1 = Integer.parseInt(s[0]);
			n2 = Integer.parseInt(s[1]);
			arr = new int[n1][n2];
			check = new int[n1][n2];
			int x =0;
			int y =0;
			for (int j = 0; j < Integer.parseInt(s[2]); j++) {
				String[] str = br.readLine().split(" ");
				x = Integer.parseInt(str[0]);
				y = Integer.parseInt(str[1]);
				arr[x][y] = 1;
			}
			each = 0;
			for (int j = 0; j < n1; j++) {
				for (int j2 = 0; j2 < n2; j2++) {
					if(arr[j][j2] == 1 && check[j][j2] == 0) {
						each ++;
						dfs(j,j2);
					}
				}
			}
			System.out.println(each);
		}
    }
    public static void dfs(int x,int y) {
    	int[] dr_y = {0,1,0,-1};
    	int[] dr_x = {1,0,-1,0};
    	int ny =0;
    	int nx =0;
    	
    	for (int i = 0; i < 4; i++) {
    		ny = y + dr_y[i];
    		nx = x + dr_x[i];
    		if(0 <= ny && ny < n2 && 0<= nx && nx < n1){
    			if(check[nx][ny] == 0 && arr[nx][ny] == 1 ) {
    				check[nx][ny] = 1;
    				dfs(nx,ny);
    			}
    		}
		}
    }
}
