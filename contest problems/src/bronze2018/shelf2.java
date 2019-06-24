package bronze2018;
import java.util.*;
import java.io.*;
public class shelf2 {
	static Scanner in = new Scanner(System.in);
	static int num;
	static int size;
	static int[] cows;
	public static void main(String[] args) {
		try {
			init();
			
			System. out.print(solve());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void init() {
		num = in.nextInt();
		size = in.nextInt();
		cows = new int[num];
		for(int i = 0; i < num; i++) {
			cows[i] = in.nextInt();
		}
	}
	public static String solve() {
		Arrays.sort(cows);
		int sum = 0;
		for(int i = 0; i < cows.length; i++) {
			sum = sum + cows[i];
			if(sum >= size) {
				break;
			}
		}
		
		int remainder = sum - size;
		System.out.println(remainder);
		for(int i = cows.length-1; i>=0; i--) {
			if(remainder - cows[i] >= 0) {
				sum = sum - cows[i];
				remainder = remainder - cows[i];
			}
		}
		remainder =sum - size;
		return Integer.toString(remainder);
	}
}
