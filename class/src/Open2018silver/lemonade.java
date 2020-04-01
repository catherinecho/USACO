package Open2018silver;
import java.util.*;
import java.io.*;
public class lemonade {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter out = new PrintWriter(new File("lemonade.out"));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr= new int[n];
		for(int i= 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int line = 0;
		int ans = 0;
		for(int i = n-1; i >=0; i--) {
			if(arr[i] >= line) {
				ans++;
			} else {
				break;
			}
			line++;
		}
		out.println(ans);
		in.close();
		out.close();
	}
}
