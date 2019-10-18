package bronze2019jan;
import java.util.*;
import java.io.*;
public class shell {
	static Scanner in;
	static int n;
	static int count;
	static int[] pebble;
	static input[] shell;
	
	public static void main(String[] args) throws IOException{
		PrintWriter out = new PrintWriter("shell.out");
		in = new Scanner(new File("shell.in"));
		count = 0;
		n = in.nextInt();
		pebble = new int[3];
		shell = new input[n];
		for(int i = 0; i < n; i++) {
			shell[i] = new input(in.nextInt()-1, in.nextInt()-1, in.nextInt()-1);
		}
		for(int i = 0; i < 3; i++) {
			pebble = new int[3];
			pebble[i] = 1;
			for(int j = 0; j < n; j++) {
				count = Math.max(swap(), count);
			}
		}
		out.println(count);
		in.close();
		out.close();
	}
	public static int swap() {
		int c = 0;
		for(int i = 0; i < n; i++) {
			int temp = pebble[shell[i].switch1];
			pebble[shell[i].switch1] = pebble[shell[i].switch2];
			pebble[shell[i].switch2] = temp;
			if(pebble[shell[i].guess] == 1) {
				c++;
			}
		}
		return c;
	}
}
class input{
	int switch1;
	int switch2;
	int guess;
	public input(int s1, int s2, int g) {
		switch1 = s1;
		switch2 = s2; 
		guess = g;
	}
}
