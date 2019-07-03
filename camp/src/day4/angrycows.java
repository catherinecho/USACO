package day4;
import java.util.*;
public class angrycows {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int k = in.nextInt();
	static int[] hay = new int[n];
	public static void main(String[] args) {
		for(int i = 0; i <  n; i++) {
			hay[i] = in.nextInt();
		}
		Arrays.sort(hay);
		System.out.println(search());
	}
	public static int search() {
		int l = 1;
		int h = 500000000;
		while(l < h) {
			int mid = (l+h) / 2;
			if(verify(mid) == true) {
				h = mid;
			}else {
				l = mid+ 1;
			}
			
		}
		return h;
	}
	public static boolean verify(int r) {
		int ind = hay[0] + (2*r);
		int nr = 1;
		for(int i =0; i < n; i++) {
			if(hay[i] <= ind) {
				continue;
			}else {
				ind = hay[i] + (2* r);
				nr++;
			}
		}
		if(nr > k) {
			return false;
		}else {
			return true;
		}
	}
}
