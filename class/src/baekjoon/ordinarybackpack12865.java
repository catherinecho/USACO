package baekjoon;

import java.util.*;
public class ordinarybackpack12865 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] memo = new int[n][k+1];
		for(int i = 0; i < n; i++) {
			int w = in.nextInt();
			int v = in.nextInt();
			for(int j = 0; j <= k; j++) {
				if (j== 0) {
					memo[i][j] = 0;
				}
				if(i == 0) {
					if(j < w) {
						memo[i][j] = 0;
					}else {
						memo[i][j] = v;
					}
				}
				else {
					if(j < w) {
						memo[i][j] = memo[i-1][j];
					}else {
						if(memo[i-1][j-w] + v > memo[i-1][j]) {
							memo[i][j] = memo[i-1][j-w] + v;
						}else {
							memo[i][j] = memo[i-1][j];
						}
					}
				}
			}
			
		}
		System.out.println(memo[n-1][k]);
	}
}

