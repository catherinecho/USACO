package Open2020silver;
import java.util.*;
import java.io.*;
public class moop2 {
	static boolean[] check;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("moop.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		particle[] p = new particle[n];
		check = new boolean[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			p[i] = new particle(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		adj = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			adj[i]= new ArrayList<Integer>();
		}
		
		for(int i = 0; i < n; i++) {
			particle a= p[i];
			for(int j = 0; j < n; j++) {
				if(i ==j) {
					continue;
				}
				particle b = p[j];
				if(a.x <= b.x && a.y <= b.y){
					if(!adj[i].contains(j)) {
						adj[i].add(j);
					}
					if(!adj[j].contains(i)) {
						adj[j].add(i);
					}
				}else if(a.x >= b.x && a.y >= b.y) {
					if(!adj[i].contains(j)) {
						adj[i].add(j);
					}
					if(!adj[j].contains(i)) {
						adj[j].add(i);
					}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			dfs(i);
		}
		
	}
	public static void dfs(int index) {
		if(check[index]) {
			return;
		}
		check[index] = false;
		for(int i = 0; i < adj[index].size(); i++) {
			dfs(adj[index].get(i));
		}
	}
	static class particle {
		int x;
		int y;
		public particle (int X, int Y) {
			x = X;
			y = Y;
		}
	}
}
