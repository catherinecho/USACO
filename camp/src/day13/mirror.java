package day13;
import java.util.*;
public class mirror {
	public static void main(String[] arga) {
		Scanner in = new Scanner(System.in);
		int n  = in.nextInt(); 
		int m = in.nextInt(); 
		char[][] mirrors = new char[n][m];
		boolean[][] visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String line = in.nextLine();
			for(int j = 0; j < m; j++) {
				mirrors[i][j] = line.charAt(j);
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(i != 0 || j != 0) {
					continue;
				}
			}
		}
	}
}
