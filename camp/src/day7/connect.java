package day7;
import java.util.*;
public class connect {
	static Scanner in = new Scanner(System.in);
	static int n=  in.nextInt();
	static int[] a = new int[n+2];
	static int ans = 0;
	static boolean[] b =new boolean[n+1];
	static cow[] cows = new cow[n+2];
	static cow farmer = new cow(0,0);
	public static void main(String[] args) {
		for(int i = 1 ; i <= n; i++) {
			cows[i] = new cow(in.nextInt(), in.nextInt());
		}
		cows[0] = new cow(0, 0);
		cows[n+1] = new cow(0, 0);
		a[n+1] = n+1;
		a[0] = 0;
		
		f(1);
		System.out.println(ans);
	
	}
	
	public static void f(int x) {
		if(x == n+1) {	
			if(valid()) {

				ans++;
			}
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(b[i] == false) {
				b[i] = true;
				a[x] = i;
				f(x+1);
				b[i] = false;
			}
		}
	}
	
	public static boolean valid() {
		if(cows[a[1]].x != farmer.x && cows[a[1]].y != farmer.y) {
			return false;
		}
		
		for(int i = 1; i <= n+1; i++) {
			if(getDir(cows[a[i]].x, cows[a[i]].y,cows[a[i-1]].x, cows[a[i-1]].y) == -1) {
				return false;
			}
		}
		for(int i = 1; i <= n; i++) {
			if(getDir(cows[a[i-1]].x, cows[a[i-1]].y, cows[a[i]].x, cows[a[i]].y) == getDir(cows[a[i]].x, cows[a[i]].y, cows[a[i+1]].x, cows[a[i+1]].y)) {
				return false;
			}
		}
		return true;
		
	}
	public static int getDir(int x1, int y1, int x2, int y2) {
		if(x1 == x2 && y1 < y2) {
			return 1;
		}
		if(x1 == x2 && y1>y2) {
			return 3;
		}if(y1 == y2 && x1 < x2) {
			return 2;
		}if(y1 == y2 && x1> x2) {
			return 4;
		}
		return -1;
	}
	
	

}

class cow{
	int x;
	int y;
	public cow( int X, int Y) {
		this.x = X;
		this.y = Y;
	}
	public int getX() {return x;}
	public int getY() {return y;}
}

