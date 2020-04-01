package Feb2020silver;
import java.util.*;
import java.io.*;
public class clocktree {
	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static int[] pass;
	static int[] pass2;
	static ArrayList<Integer>[] graph;
	static int ans = 0;
	public static void main(String[] args)throws IOException{
		in = new BufferedReader (new FileReader("clocktree.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n];
		pass = new int[n];
		 st = new StringTokenizer(in.readLine());
		for(int i= 0; i < n; i++) {
			pass[i] = 12 - Integer.parseInt(st.nextToken());
		}
		pass2 = pass.clone();
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i  = 0; i < n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int num1 = Integer.parseInt(st.nextToken())-1;
			int num2 = Integer.parseInt(st.nextToken())-1;
			graph[num1].add(num2);
			graph[num2].add(num1);
			
		}
		/*
		System.out.println(Arrays.toString(pass));
		for(int i = 0; i < n; i++) {
			System.out.print(i + ": ");
			for(int j = 0; j < graph[i].size(); j++) {
				System.out.print(graph[i].get(j) + " " );
			}
			System.out.println();
		}
		*/
		int[] compare = new int[n];
		for(int i = 0; i < n; i++) {
			compare[i] = 0;
		}

		int[] original = new int[n];
		original = pass.clone();
		//System.out.println(Arrays.toString(original));
		for(int i = 0; i <2 ; i++) {
			pass[i] = pass[i] +1;
			pass2[i] = pass2[i] +1;
			dfs(i,compare);
			//System.out.println(Arrays.toString(pass));
			//System.out.println();
			if(Arrays.equals(pass2, compare)) {
				ans++;
			}
			pass = original.clone();
			pass2 = original.clone();
		}
		out.println(ans);
		out.close();
		in.close();
		
	}
	static boolean check = false;
	
	public static void dfs(int current, int[] compare) {
		
		if(Arrays.equals(pass2, compare)) {
			check = true;

		}
		if(pass[current]==0) {
			return;
		}
		pass[current]--;
		pass2[current]--;
	//	System.out.println("pass: " + Arrays.toString(pass));
	//	System.out.println("pass2: " +Arrays.toString(pass));
		for(int x = 0; x < graph[current].size(); x++) {
			int next = graph[current].get(x);
			// visit_count[next]--;
			//System.out.println(pass2[current]);
			dfs(next,compare);
			// visit_count[next]++;
		}
		if(check == false) {
			
			pass2[current]+= 1;
			//System.out.println(Arrays.toString(pass2));
		}
			return;
	
	
	//	System.out.println(Arrays.toString(pass));
	}

	
}
