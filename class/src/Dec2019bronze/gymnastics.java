package Dec2019bronze;
import java.util.*;
import java.io.*;
public class gymnastics {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int n = in.nextInt();
		int[][] rank = new int[k][n];
		boolean[][] numbers = new boolean[k][n];
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				int temp = in.nextInt();
				rank[i][j] =temp;
			}
		}
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(rank[i][j]);
			}
			System.out.println();
		}

		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				for(int m = 0; m < k; m++) {
					if(rank[m][i] > rank[m][j]) {
						
					}
				}
			}
		}
		
	}
}
