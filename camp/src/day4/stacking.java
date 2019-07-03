package day4;
import java.util.*;
public class stacking {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n + 1];
		int q=in.nextInt();
		for(int i = 0; i < q; i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			s[l]++;
			s[r+1]--;
		}
		int[] prefSum = new int[n+1];
		for(int i = 1; i < n + 1; i++) {
			prefSum[i] = prefSum[i-1] + s[i];
		}
		
		System.out.println(Arrays.toString(prefSum));
		Arrays.sort(prefSum,1,n);
		System.out.println(Arrays.toString(prefSum));
		System.out.println(prefSum[(n+1)/2]);
		
	}
}
