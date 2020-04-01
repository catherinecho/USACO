package Feb2020bronze;
import java.util.*;
import java.io.*;
public class breedflip {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("breedflip.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		String original = in.readLine();
		String line  = in.readLine();
		int ans = 0;
		boolean t = false;
		for(int i = 0 ; i < n; i++) {
			if(original.charAt(i) != line.charAt(i)) {
				t = true;
			}else {
				if(t == true) {
					ans++;
				}
				t = false;
			}
			
		}
		out.println(ans);
		in.close();
		out.close();
	}
}
