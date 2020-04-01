package Dec2015bronze;
import java.util.*;
import java.io.*;
public class paint {
	
	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(new File("paint.in"));
		PrintWriter out = new PrintWriter( new File("paint.out"));
		int john1 = in.nextInt();
		int john2 = in.nextInt();
		int cow1 = in.nextInt();
		int cow2 = in.nextInt();
		if(john1 == cow1 && cow2 == john2) {
			out.println(cow2-cow1);
			out.close();
			in.close();
			
		}
		if( (cow1 < john2 && cow1 > john1) || (john1 > cow1 && john1 < cow2)) {
			int low = Math.min(john1, cow1);
			int high = Math.max(john2, cow2);
			out.println(high - low);
		
		}else {
			out.println((john2-john1) + (cow2-cow1));
			
		}
		
		out.close();
		in.close();
		
	}
}
