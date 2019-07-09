package day12;
import java.util.*;
public class cowdance {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int tmax = in.nextInt();
	static int[] cows = new int[n];
	public static void main(String[]args) {
		for(int i = 0; i < n; i++) {
			cows[i] = (in.nextInt());
		}
		
		System.out.println(search());
	}
	public static int search() {
		int l = 1;
		int h = n;
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
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int time = 0;
		for(int i = 0; i < n; i++) {
			if(pq.size() == r) {
				time = pq.remove();
		
			}
			pq.add(time+ cows[i]);
			if(time+cows[i] > tmax) {
				return false;
			}
		}
		return true;
		
	}
}
