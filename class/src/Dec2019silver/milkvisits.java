package Dec2019silver;
import java.util.*;
import java.io.*;
public class milkvisits {
	static BufferedReader in;
	static PrintWriter out;
	static char[] type;
	static ArrayList<Integer>[] adj ;
	static int[] parent;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("milkvisits.in"));
		out = new PrintWriter (new BufferedWriter(new FileWriter("milkvisits.out")));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj= new ArrayList[N];
		visited = new boolean[N];
		StringBuilder ans = new StringBuilder();
		parent= new int[N];
		type = in.readLine().toCharArray();
		//System.out.println(Arrays.toString(type));
		for(int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int x = 0; x < N-1; x++) {
			st = new StringTokenizer(in.readLine());
			int cow1 = Integer.parseInt(st.nextToken())-1;
			int cow2 = Integer.parseInt(st.nextToken())-1;
			adj[cow1].add(cow2);
			adj[cow2].add(cow1);
		}
		//System.out.println(Arrays.toString(adj));
		
		dfs(0,0);
		//System.out.println(Arrays.toString(parent));
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x=  Integer.parseInt(st.nextToken())-1;
			int y  =  Integer.parseInt(st.nextToken())-1;
			char t = st.nextToken().charAt(0);
			if((type[x] == type[y]) && type[x] != t) {
				if(parent[x] == parent[y] ){
					ans.append(0);
				}else {
					ans.append(1);
				}
			}else {
				ans.append(1);
			}
		}
		out.println(ans.toString());
		out.close();
		in.close();
	}
	
	
	public static void dfs(int par, int curr) {
		
		visited[curr] = true;
		if(type[par] != type[curr]) {
			par = curr;
		}
		parent[curr] = par;
		for(int i: adj[curr]) {
			if(!visited[i]) 
				dfs(par,i);
			
		}
		
	}
	
}
