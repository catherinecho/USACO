package bronze2019jan;
import java.util.*;
import java.io.*;
public class sleepy {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("sleepy.in"));
		PrintWriter out = new PrintWriter("sleepy.out");
		int n = in.nextInt();
		int[] line = new int[n];
		int a = 0;
		for(int i = 0; i < n; i++) {
			line[i] = in.nextInt();
		}
		for(int i = n-1; i >0; i--) {
			if(line[i] < line[i-1]) {
				a= i;
				break;
			}
		}
		out.println(a);
		in.close();
		out.close();
	}
}
