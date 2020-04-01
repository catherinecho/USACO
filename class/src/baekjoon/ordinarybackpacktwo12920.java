package baekjoon;
import java.util.*;
public class ordinarybackpacktwo12920 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		ArrayList<stuff>list = new ArrayList<stuff>();
		for(int i = 0; i < n; i++) {
			int weight = in.nextInt();
			int satisfy = in.nextInt();
			int things = in.nextInt();
			for(int j = 0; j < things; j++) {
				list.add(new stuff(weight, satisfy));
			}
		}
		int[] memo= new int[k+1];

		for(int i = 0; i < list.size(); i++) {
			for(int  j = k; j >= 0; j--) {
				if(j < list.get(i).w) {
					continue;
				}
				if(memo[j] < list.get(i).v + memo[j-list.get(i).w]) {
					memo[j] = list.get(i).v + memo[j-list.get(i).w];
 				}
			}
			System.out.println(Arrays.toString(memo));
		}
		
		/*
 		int[][] memo = new int[list.size()][k+ 1];
 		for(int i = 0; i < list.size(); i++) {
			int w = list.get(i).w;
			int v = list.get(i).v;
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
 		
		System.out.println(memo[list.size()-1][k]);
		*/
	}
}
class stuff{
	int w;
	int v;
	public stuff(int weight, int value) {
		w =weight;
		v = value;
	}
}
