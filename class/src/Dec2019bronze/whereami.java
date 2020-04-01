package Dec2019bronze;
import java.util.*;
import java.io.*;
public class whereami {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File ("whereami.in"));
		PrintWriter out = new PrintWriter(new File("whereami.out"));
		int n = in.nextInt();
		String input = in.next();
		int ans = 0;
		
		for(int i = 1; i <= n; i++) {
			boolean a =true;
			for(int j = 0; j < n-i; j++) {
				String stuff = input.substring(j, j+i);
				//System.out.println(stuff + " " + j + " " + j+i);
				if(input.indexOf(stuff) != input.lastIndexOf(stuff)) {
					a = false;
					break;
				}
			}
			if(a == true) {
				ans = i;
				break;
			}
			
		}
		out.println(ans);
		in.close();
		out.close();
		
	}
}
