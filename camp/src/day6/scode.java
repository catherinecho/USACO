package day6;
import java.util.*;
public class scode {
	static Scanner in = new Scanner(System.in);
	static String word = in.next();
	public static void main(String[] args) {
		
		System.out.println(f(word)-1);
		
		
	}
	public static int f(String s) {
		int ans = 1;
		int n = s.length();
		if(s.length() % 2 == 0 && n ==1) {
			return 1;
		}
		// ABC --> AB + ABC
		if((s.substring(0, n/2)).equals(s.substring(n/2, n-1))) {
			ans += f(s.substring(n/2,n));
			
		}
		
		//ABC --> ABC + AB
		if((s.substring(0,n/2)).equals(s.substring(n/2 + 1))) {
			ans += f(s.substring(0,n/2+1));
		}
		// ABC --> BC + ABC
		if((s.substring(0,n/2)).equals(s.substring(n/2 + 1))) {
			ans += f(s.substring(n/2));
		}
		// ABC --> ABC + BC
		if((s.substring(1,n/2+ 1)).equals(s.substring(n/2+ 1))) {
			ans+= f(s.substring(0,n/2+1));
		}
		return ans;
	}
}
