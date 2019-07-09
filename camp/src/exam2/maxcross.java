package exam2;
import java.util.*;
public class maxcross {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int k = in.nextInt();
	static int b = in.nextInt();
	static int[] signals = new int[n];
	static int[] combo = new int[k];
	public static void main(String[] args) {
		for(int i =0 ; i < b; i++) {
			signals[in.nextInt()-1] = -1;
		}
		/*
		for(int i =0 ; i < n; i++) {
			System.out.println(signals[i]);
		}
		*/
		int count = 0;
		int ans = n;
		for(int i = 0; i <= n - k; i++) {
			count=  0;
			for(int j = i; j < i + k; j++) {
				
				//System.out.print(signals[j]);
				if(signals[j] == -1) {
					count++;
				}
			}
			//System.out.println();
			if(count < ans) {
				ans = count;
			}
		}
		System.out.println(ans);
		//f(0);
	}
	
}
