package Dec2019silver;
import java.util.*;
import java.io.*;
public class moobuzz {
	static Scanner in;
	static PrintWriter out;
	static int n;

	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("moobuzz.in"));
		out = new PrintWriter (new File("moobuzz.out"));
		n = in.nextInt();
		int line = n / 8;
		if(n % 8 ==0) {line--;}
		int first = 1 +(15 *line);
		
		int[] temp = new int[9];
		for(int i = 0; i < 9 ; i++) {
			if(i == 1 || i == 4 || i == 7) {first += 1;}
			else if(i == 2|| i == 6|| i==8) {first += 2;}
			else if(i == 3|| i== 5) {first += 3;}
			temp[i] = first;
		}
		int index = (line) * 8 + 1;
		int ansIndex = n - index;
		//System.out.println(index + " " + ansIndex);
		out.println(temp[ansIndex]);
		in.close();
		out.close();
	}
}
