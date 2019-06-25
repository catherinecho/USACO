package day1;
import java.io.*;
import java.util.*;
public class speeding {
	static Scanner in = new Scanner(System.in);
	static int[] l;
	static int[] cows;
	static int n;
	static int m;
	static int start;
	static int pos;
	public static void main(String[] args) {
		try {
			init();
			System. out.print(solve());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void init() {
		l = new int[101];
		cows = new int[101];
		n = in.nextInt();
		m = in.nextInt();
		start = 0;
		pos = 0;
	}
	public static int solve() {
		for(int j=0; j<n; j++){
			pos += in.nextInt();
			int speed = in.nextInt();
			for(int i=start; i<pos; i++){
				l[i] = speed;
			}
			start = pos;
		}
		
		start = 0;
		pos = 0; 
		for(int j=0; j<m; j++){
			pos += in.nextInt();
			int speed = in.nextInt();
			for(int i=start; i<pos; i++){
				cows[i] = speed;
			}
			start = pos;
		}
		
		int max=0;
		for(int i=0; i<101; i++){
			max = Math.max(max, cows[i]-l[i]);
		}
		
		return max;
	
	}

}