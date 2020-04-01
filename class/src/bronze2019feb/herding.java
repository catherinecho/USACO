package bronze2019feb;
import java.util.*;
import java.io.*;
public class herding {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("herding.in"));
		PrintWriter out = new PrintWriter(new File("herding.out"));
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int diff1 = c - b;
		int diff2 = b - a;
		if(diff1 == 1 & diff2 == 1) {
			out.println("0");
		}else if(diff1 == 2) {
			out.println("1");
		}else if (diff2 == 2) {
			out.println("1");
		}else {
			out.println("2");
		}
		
		out.println(Math.max(diff1, diff2) - 1);
		out.close();
		in.close();
	}
}
