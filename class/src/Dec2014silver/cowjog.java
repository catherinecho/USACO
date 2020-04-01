package Dec2014silver;
import java.util.*;
import java.io.*;
public class cowjog {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("cowjog.in"));
		PrintWriter out = new PrintWriter(new File("cowjog.out"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
	 	int time =  Integer.parseInt(st.nextToken());
		int[] list = new int[n];
		for(int i = 0; i < n;i++){
			st = new StringTokenizer(in.readLine());
			int pos =Integer.parseInt(st.nextToken());
			int rate = Integer.parseInt(st.nextToken());
			list[i] = pos + (rate * time);
		}
		int ans = n;
		int previous = list[n-1];
		for(int i = n-2; i >=0; i--){
			if(previous <= list[i]) {
			ans--;
			}
			if(previous > list[i])
			 	previous = list[i];
					
		}
		System.out.println(ans);
	}

}
