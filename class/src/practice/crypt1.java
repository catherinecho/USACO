/*
ID: ccho2011
LANG: JAVA
TASK: crypt1
*/
package practice;
import java.util.*;
import java.io.*;
public class crypt1 {
	static ArrayList<Integer> list;
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		list= new ArrayList<Integer>();
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		ArrayList<Integer> threes = new ArrayList<Integer>();
		ArrayList<Integer> twos = new ArrayList<Integer>();
		int one = 0;
		int two = 0; 
		int ans =0;
		for(int i = 0; i < n; i++) {
			for(int j = 0;j < n; j++) {
				for(int k = 0; k < n; k++) {
					one = (list.get(i) *100) + (list.get(j) *10) + list.get(k);
					two = list.get(j) *10 + list.get(k);
					if(!threes.contains(one)) {
						threes.add(one);
					}
					if(!twos.contains(two)) {
						twos.add(two);
					}
					
				}
			}
		}
		System.out.println(threes);
		
		for(int i = 0 ; i < threes.size(); i++) {
			for(int j = 0; j < twos.size(); j++) {
				int c = threes.get(i);
				int b = twos.get(j);
				int product1 = c * (b / 10);
				if(product1 > 999) {
					continue;
				}
				int product2 = c * (b%10);
				if(product2 >999) {
					continue;
				}
				int product3 = product1 + (product2*10);
				if(valid(product1) && valid(product2) && valid(product3)) {
					ans++;
				}
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}
	public static boolean valid(int n) {
		while(n >0 ) {
			int d = n%10;
			n = n / 10;
			if(!list.contains(d)) {
				return false;
			}
		}
		return true;
	}
}
