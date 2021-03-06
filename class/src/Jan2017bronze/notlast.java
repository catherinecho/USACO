package Jan2017bronze;
import java.util.*;
import java.io.*;
public class notlast {
	static Scanner in;
	static PrintWriter out;
	static int n; 
	static Map<String,Integer> list;
	static cows [] c;
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("notlast.in"));
		out = new PrintWriter(new File("notlast.out"));
		try {
			init();
			out.println(solve());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		in.close();
		out.close();
	}
	private static void init () {
		n = Integer.parseInt(in.nextLine());
		list = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++) {
			StringTokenizer line = new StringTokenizer(in.nextLine());
			String name = line.nextToken();
			int num = Integer.parseInt(line.nextToken());
			if(list.containsKey(name)) {
				list.put(name, list.get(name) + num);
			}else {
				list.put(name,num);
			}
		}
		//System.out.println(list);
		c = new cows[list.size()];
		int a = 0;
		for( Map.Entry<String,Integer> list: list.entrySet()) {
			c[a] = new cows(list.getKey(),list.getValue());
			a++;
		}
		Arrays.sort(c);
		/*
		for(int i = 0; i < list.size(); i++) {
			System.out.println(c[i].name + " " + c[i].milk);
		}
		*/
		
	}
	public static String solve() {
		boolean t = false;
		int first = c[0].milk;
		for(int i = 0; i < list.size(); i++) {
			if(c[i].milk != first) {
				t = true;
			}
		}
		if(t != true && list.size()!= 1) {
			return "Tie";
		}
		for(int i = 0 ; i < list.size(); i++) {
			if(c[i].milk != first) {
				return c[i].name;
				
			}
		}
		
		return c[0].name;
	}
}
class cows implements Comparable<cows>{
	public String name;
	public int milk;
	public int compareTo(cows m) {
		return this.milk - m.milk;

	}
	public cows(String n, int m) {
		this.name = n;
		this.milk = m;
	}
}
