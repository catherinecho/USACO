package Open2020;
import java.util.*;
import java.io.*;
public class socdist1 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("socdist1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
		int n = Integer.parseInt(in.readLine());
		String line = in.readLine();
		ArrayList<space> dist = new ArrayList<space>();
		int firstvirus = 0;
		for(int i = 0; i < n; i++) {
			if(line.charAt(i) == '1') {
				firstvirus = i;
				break;
			}
		}
		int num = firstvirus;
		ArrayList<Integer> diff = new ArrayList<Integer>();
		for(int i = num+1; i < n; i++) {
			if(line.charAt(i) == '1') {
				diff.add(Math.abs(firstvirus  - (i)));
				firstvirus = i;
			}
		}
		Collections.sort(diff);
		int ans = 0;
		if(diff.size() ==1) {
			ans = diff.get(0) / 3;
		}else {
			int max = diff.get(diff.size()-1);
			int max2 = diff.get(diff.size()-2);
			int min = Integer.MAX_VALUE;
			min = Math.min(min, max/3);
			int twomin = Math.min(max/2, max2/2);
			ans = Math.max(min, twomin);
		}
		out.println(ans);
		in.close();
		out.close();
	}
	static class space{
		int first;
		int sec;
		public space(int f, int s) {
			first = f;
			sec = s;
		}
	}
}
