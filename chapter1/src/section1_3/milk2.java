package section1_3;
/*
ID: ccho2011
LANG: JAVA
TASK: milk2
*/
import java.util.*;
import java.io.*;
public class milk2 {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static StringTokenizer st;
	static pairM[] milk = new pairM[n];
	static int start = milk[0].start;
	static int end= milk[0].end;
	static int maxMilk = end - start;
	static int noS = 0;
	static int noE = 0;
	static int maxNoMilk = noE- noS;
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("gift1.in"));
			out = new PrintWriter(new File("gift2.out"));
			init();
			out.print(solve());
			out.close();
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private static void init() {
		int n = Integer.parseInt(in.nextLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.nextLine());
			milk[i] = new pairM(Integer.parseInt(st.nextToken().trim()),Integer.parseInt(st.nextToken().trim()));
		}
		Arrays.sort(milk);
	}
	public static String solve() {
		for(int i = 1; i < milk.length; i++) {
			if(milk[i].start <= end) {
				if(milk[i].end > end) {
					end = milk[i].end;
				}
				
				if(end - start > maxMilk) {
					maxMilk = end - start;
				}
				
			}else {
				noS = end;
				noE = milk[i].start;
				
				if(noE - noS > maxNoMilk) {
					maxNoMilk = noE-noS;
					System.out.println(milk[i-1]+ " " + milk[i] + " " + maxNoMilk);
				}
				start = milk[i].start;
				if(milk[i].end > end) {
					end = milk[i].end;
				}
			}
		}
		return (Integer.toString(maxMilk) + " " + Integer.toString(maxNoMilk));
		
	}
}

class pairM {//implements Comparable<pairM>{
	int start;
	int end;
	pairM(int s, int e){
		start = s;
		end = e;
	}
	/*
	@Override
	public int compareTo(pairM arg0) {
		// TODO Auto-generated method stub
		if(this.start == arg0.start) {
			return this.end-arg0.end;
		}
		return this.start-arg0.start;
	}
	*/
	public String toString() {
		return start + " " + end;
	}
	
}