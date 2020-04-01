package Jan2020silver;
import java.util.*;
import java.io.*;
public class loan {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static long n;
	static long days;
	static long requirement;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("loan.in"));
		out = new PrintWriter(new File("loan.out") );
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		days = Integer.parseInt(st.nextToken());
		requirement =  Integer.parseInt(st.nextToken());
		out.println(search());
		in.close();
		out.close();
	}
	public static long search() {
		long l = 1;
		long h = (long)Math.pow(10, 12); // 10^12;
		while(l <  h) {
			long mid = (l+h+1) / 2;
			if(verify(mid) == true) {
				l = mid;
			}else {
				h = mid - 1;
			}
			
		}
		return l;
	}
	public static boolean verify(long mid) {
		// 1st case: if Y < requirement, Y = requirement
		long g = 0;
		while(days > 0 && g < n) { // while deadline is not passed, and/or farmer john still owes milk
			long y = (n - g) / mid;
			if(y < requirement) {
				y = requirement;
				int numdays = (int)((n - g + requirement-1) / requirement);
				return numdays <= days;

			} else {
				// decrease requirement mathematically
				int numdays = (int)(((n - mid * y) - g) / y + 1);
				numdays = Math.min(numdays, (int)(days));
				days -= numdays;
				g += numdays * y;
			}
		}
		if(days <= 0)
			return false;
		return true;
	}

}
