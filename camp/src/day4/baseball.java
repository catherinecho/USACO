package day4;
import java.util.*;
public class baseball {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	public static void main(String [] args) {
		int[] location = new int[n];
		for(int i =0 ; i< n; i++) {
			location[i] = in.nextInt();
		}
		Arrays.sort(location);
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i+ 1; j< n; j++) {
				int a = low(location, location[j] + (location[j] - location[i]));
				int b = upper (location, location[j] + 2 *(location[j] - location[i]));
				//System.out.print(low(location, location[j] + (location[j] - location[i])) + " ");
				//System.out.println(upper (location, location[j] + 2 *(location[j] - location[i])));
				ans = ans + (b - a);
			}
		}
		System.out.println(ans);
		
		
	}
	public static int low(int[] location, int target) {
		int l = 0;
		int h = n;
		while(l < h) {
			int mid = (l + h) / 2;
			if(location[mid] >= target) {
				h = mid;
			}else {
				l = mid+1;
			}
		}
		return h;
	}
	public static int upper(int[] location, int target) {
		int l = 0;
		int h = n;
		while(l < h) {
			int mid = (l + h) / 2;
			if(location[mid] > target) {
				h = mid;
			}else {
				l = mid+1;
			}
		}
		return h;
	}
}
