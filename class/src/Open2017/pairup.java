package Open2017;
import java.util.*;
import java.io.*;
public class pairup {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("pairup.in"));
		PrintWriter out = new PrintWriter(new File("pairup.out") );
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int max = 0;
		ArrayList<cow> pairs = new ArrayList<cow>();
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pairs.add(new cow(v, k));
		}
		Collections.sort(pairs);
		while(pairs.size() > 1) {
			if(pairs.get(0).num > pairs.get(pairs.size()-1).num) {
				pairs.get(0).num = pairs.get(0).num - pairs.get(pairs.size()-1).num;
				max = Math.max(pairs.get(0).value + pairs.get(pairs.size()-1).value, max);
				pairs.remove(pairs.size()-1);
			}
			else if(pairs.get(0).num < pairs.get(pairs.size()-1).num) {
				pairs.get(pairs.size()-1).num = pairs.get(pairs.size()-1).num - pairs.get(0).num;
				max = Math.max(pairs.get(0).value + pairs.get(pairs.size()-1).value, max);
				pairs.remove(0);
			}else {
				max = Math.max(pairs.get(0).value + pairs.get(pairs.size()-1).value, max);
				pairs.remove(0);
				pairs.remove(pairs.size()-1);
			}
		}
		if(pairs.size() ==1) {
			max = Math.max(pairs.get(0).value + pairs.get(0).value , max);
		}
		
		out.println(max);
		out.close();
		in.close();
	}
	static class cow implements Comparable<cow>{
		int value;
		int num;
		public cow(int V, int N) {
			value = V;
			num = N;
		}
		public int compareTo(cow m) {
			if (this.value > m.value) {
				return 1;
			}
			return -1;
		}
	}
}