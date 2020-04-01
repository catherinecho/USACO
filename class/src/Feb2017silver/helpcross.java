package Feb2017silver;
import java.util.*;
import java.io.*;
public class helpcross {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("helpcross.in"));
		PrintWriter out = new PrintWriter(new File("helpcross.out"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		moo[] line = new moo[c+n];
		for(int i = 0; i < c; i++) {
			int temp = Integer.parseInt(in.readLine());
			line[i] = new moo(temp, temp, false);
		}
		for(int i = c; i < c+n; i++) {
			st = new StringTokenizer(in.readLine());
			line[i] = new moo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), true);
		}
		Arrays.sort(line);
		/*
		for(int i = 0 ; i < line.length; i++) {
			System.out.println(line[i].start + " " + line[i].end + " " + line[i].ch);
		}
		
		*/
		int ans = 0;
		PriorityQueue <Integer> hi = new PriorityQueue<Integer>();
		for(int i = 0; i < line.length; i++) {
			if(line[i].ch == true) {
				hi.add(line[i].end);
			}else if(line[i].ch == false){
				for(int j =0; j < hi.size(); j++) {
					int temp = hi.poll();
					//System.out.println(temp+ " " + line[i].start + " " + line[i].end );
					if(temp >= line[i].start ) {
						ans++;
						break;
					}
				}
				
			}
		}
		out.println(ans);
		
		in.close();
		out.close();
	}
}
class moo implements Comparable<moo>{
	public int start;
	public int end;
	public boolean ch;
	public int compareTo(moo m) {
		if(this.start == m.start) {
			if(this.ch && !m.ch) {
				return -1;
			}
			if(!this.ch && m.ch) {
				return 1;
			}
		}
		return this.start - m.start;
	}
	public moo(int s, int e, boolean c) {
		start = s;
		end = e;
		ch = c;
	}
}