package day4;
import java.util.*;
public class mnotes {
	static int[] beats;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int b = in.nextInt();
		int c = in.nextInt();

		beats = new int[b+ 1];
		
		beats[0] = 0;
		for(int i = 1; i <= b; i++) {
			beats[i] = beats[i-1] + in.nextInt();
		}
		for(int i = 0; i < c; i++) {
			int y = in.nextInt();
			System.out.println(upper(y));
		}
	}
	public static int upper(int x) {
		int l=0;
		int h= beats.length;
		while(l < h) {
			int mid = (l+h)/2;
			if(beats[mid] > x) h = mid;
			else l = mid+1;
		}
		
		return h;
	}
}
