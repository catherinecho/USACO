package day12;
import java.util.*;
public class rs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < n; i++) {
			pq.add(in.nextInt());
		}
		while(pq.size()> 1) {
			int a = pq.remove();
			int b = pq.remove();
			pq.add(a+b);
			ans+= a+b;
		}
		System.out.println(ans);
	}
}
