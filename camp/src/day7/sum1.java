package day7;
import java.util.*;
public class sum1{
	static Scanner in = new Scanner(System.in);
	static long n = in.nextLong();
	static int mod = 1000000007;
	static long ans = 0;
	public static void main(String[] args) {
		ans = pow(n+1);
		System.out.print(ans - 1);
		
	}
	public static long pow(long n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return 2;
		}
		long x = pow(n/2) % mod;
		if(n%2 == 0) {

			return (x*x) % mod;
		}else {

			return (((x*x) % mod)* 2) % mod;
		}
	}
}
