package day4;
import java.util.*;

public class haybales {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	public static void main(String[] args) {
		
		int[] hay = new int[n];
		int q = in.nextInt();
		for(int i = 0; i < n; i++) {
			hay[i] = in.nextInt();
		}
		Arrays.sort(hay);

		questions[] Q = new questions[q];
		for(int i = 0; i < q; i++) {
			Q[i] = new questions(in.nextInt(), in.nextInt());
		}
		int count = 0;
		for(int i = 0;i < q; i++) {
			int a = upper(hay, Q[i].getEnd());
			int b = low(hay, Q[i].getStart());
			System.out.println(a-b);
		}
		
	}
	public static int low(int[] hay, int target) {
		int l = 0;
		int h = n;
		while(l < h) {
			int mid = (l + h) / 2;
			if(hay[mid] >= target) {
				h = mid;
			}else {
				l = mid+1;
			}
		}
		return h;
	}
	public static int upper(int[] hay, int target) {
		int l = 0;
		int h = n;
		while(l < h) {
			int mid = (l + h) / 2;
			if(hay[mid] > target) {
				h = mid;
			}else {
				l = mid+1;
			}
		}
		return h;
	}
}
class questions{
	int start;
	int end;
	
	public questions(int s, int e) {
		this.start = s;
		this.end = e;
	}
	public int getStart() {return start;}
	public int getEnd() {return end;}
}
