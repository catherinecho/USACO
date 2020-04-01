package Open2020silver;
import java.util.*;
import java.io.*;
public class cereal2 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("cereal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		pair[] cows = new pair[n];
		ArrayList<Integer> pri = new ArrayList<Integer>();
		ArrayList<Integer> sec = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			cows[i] = new pair(Integer.parseInt(st.nextToken()),false, Integer.parseInt(st.nextToken()), false);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i =0 ; i<n;i++) {
			if(!q.contains(cows[i].pri)) {
				q.add(cows[i].pri);
				cows[i].one = true;
			}
			pri.add(cows[i].pri);
		}
		for(int i =0 ; i<n;i++) {
			if(cows[i].one == false) {
				if(!q.contains(cows[i].sec)) {
					q.add(cows[i].sec);
					cows[i].two = true;
				}
			}
			sec.add(cows[i].sec);
			
		}
		ArrayList<Integer> nonepri = new ArrayList<Integer>();
		ArrayList<Integer> nonesec= new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			if(cows[i].one == false && cows[i].two == false) {
				nonepri.add(cows[i].pri);
				nonesec.add(cows[i].sec);
			}
		}
		System.out.println(q.size());
		for(int i = 0; i < n-1; i++) {
			int num = 0;
			if(q.contains(cows[i].pri)) {
				num = cows[i].pri;
				q.remove(cows[i].pri);
			}else {
				num = cows[i].sec;
				q.remove(cows[i].sec);
			}
			if(nonepri.contains(num)) {
				q.add(num);
				int index = nonepri.indexOf(num);
				nonepri.remove(index);
				nonesec.remove(index);
			}else if(nonesec.contains(num)){
				q.add(num);
				int index = nonesec.indexOf(num);
				nonepri.remove(index);
				nonesec.remove(index);
			}
			System.out.println(q.size());
			
		}
		
	}
	static class pair{
		int pri;
		boolean one;
		int sec;
		boolean two;
		public pair(int p, boolean o, int s, boolean t) {
			pri= p;
			one = o;
			sec = s;
			two = t;
		}
	}
}
