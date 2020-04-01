package Dec2018silver;
import java.util.*;
import java.io.*;
public class convention2 {
	static Scanner in ;
	static PrintWriter out;
	static int n;
	static cow[] cows;
	public static void main(String [] args) throws IOException{
		in = new Scanner(new File("convention2.in"));
		out = new PrintWriter(new File("convention2.out"));
		n = in.nextInt();
		cows = new cow[n];
		for(int i= 0; i < n; i++) {
			StringTokenizer line= new StringTokenizer(in.nextLine());
			cows[i] = new cow(Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken()), i);
		}
		Arrays.sort(cows);
		for(int i = 0; i < n; i++) {
			System.out.println(cows[i].arrive);
		}
		
	}
}
class cow implements Comparable<cow> {
	int arrive;
	int time;
	int priority;
	public int compareTo(cow m) {
		if(m.arrive - this.arrive < 0) {
			return m.arrive-this.arrive;
		}else {
			return this.arrive- m.arrive;
		}
	}
	public cow(int a, int t, int p) {
		this.arrive = a;
		this.time = t;
		this.priority = p;
	}
}