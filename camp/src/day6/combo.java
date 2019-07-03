package day6;
import java.util.*;
public class combo {
	static Scanner in = new Scanner(System.in);
	static int n=  in.nextInt();
	static int count = 0;
	static int[] farmer = new int[3];
	static int[] mas = new int[3];
	static int[] a = new int[4];
	static int ans = 0;
	public static void main(String[] args) {
		
		for(int i = 0; i < 3; i++) {
			farmer[i] = in.nextInt();
		}
		for(int i = 0; i < 3; i++) {
			mas[i] = in.nextInt();
		}
		
		
		digitG(1);
		System.out.println(ans);
		
	
	}
	public static void digitG(int x) {
		if(x == 4) {
			if(valid()) {
				ans++;
			}
			
			return;
		}
		for(int i = 1; i <= n; i++) {
			a[x] = i;
			digitG(x+ 1);
		}
	}
	
	public static boolean valid() {
		if(close(a[1], farmer[0]) && close(a[2], farmer[1] ) && close(a[3], farmer[2])) {
			return true;
		}
		if(close(a[1], mas[0]) && close(a[2], mas[1] ) && close(a[3], mas[2])) {
			return true;
		}
		return false;
	}
	public static boolean close(int i, int j) {
		int diff = 0;
		diff = Math.abs(j - i);
		if(diff <= 2 || diff >= n-2) {
			return true;
		}
		return false;
	}
	
	
	
	
}
