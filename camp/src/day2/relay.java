package day2;
import java.util.*;
public class relay {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cownum = in.nextInt();
		int[] cows = new int[cownum];
		for(int i = 0; i < cownum; i++) {
			cows[i] = in.nextInt();
		}
		int[] noloop = new int[cownum+2];
		int count = 0;
		for(int i = 0; i < cownum; i++) {
			if(cows[i] == 0) {
				noloop[i] = 1;
			}
		}
		for(int i = 0; i < cownum; i++) {
			for(int j = 0; j < cownum; j++) {
				if(noloop[cows[j]] == 1) {
					noloop[j+1] = 1;
				}
			}
		}
		for(int i = 1; i <= cownum; i++) {
			if(noloop[i] == 1) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
