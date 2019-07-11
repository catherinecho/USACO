package day14;
import java.util.*;
public class cbuying {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static long b = in.nextLong();
	static choco[] greed = new choco[n];
	static long ans = 0;
	public static void main(String[] args) {
		for(int i = 0; i < n; i++) {
			greed[i] = new choco(in.nextLong(), in.nextLong());
		}
		Arrays.sort(greed);
		
		for(int i = 0; i < n; i++) {
			long c = b / greed[i].chocolate;
			c = Math.min(c, greed[i].cows);
			if(b - (c * greed[i].chocolate) < 0)
				break;
			b = b - (c * greed[i].chocolate);
			ans+= c;
			
		}
		System.out.println(ans);
	}
	
}
class choco implements Comparable<choco>{
	long chocolate;
	long cows;
	public int compareTo(choco m) {
		if(this.chocolate < m.chocolate) {
			return -1;
		}else {
			return 1;
		}
	}
	public choco(long ch, long c) {
		this.chocolate = ch;
		this.cows = c;
	}
}