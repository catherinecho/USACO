package day3;
import java.util.*;
public class odometer {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long c = in.nextLong();
		long y = in.nextLong();
		int ans = 0;
		for(int i = 3; i <= 4; i++) {
			for(int j = 0; j <= 9; j++) {
				String[] s = new String[i];
				for(int x = 0; x < i; x++) {
					s[x] = Integer.toString(j);
				}
				for(int z= 0; z <s.length; z++) {
					for(int d = 0; d<= 9; d++) {
						if(j == d) {
							continue;
						}
						s[z] = Integer.toString(d);
						long num = 0;
						for(int r = 0; r < s.length; r++) {
							num = num* 10 + Long.parseLong(s[r]);
						}
						
						if(s[0].equals("0")==false && c <=num && num <= y) {
							ans++;
							
						}
					}
					s[z] = Integer.toString(j);
				}
			}
		}
		System.out.println(ans);
	}
}
