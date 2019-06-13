/*
ID: ccho2011
LANG: JAVA
TASK: friday
*/
package section1_2;
import java.util.*;
import java.io.*;
public class friday {
	static Scanner in;
	static PrintWriter out;

	static int years;
	static int current;
	static int[] week; 
	static String result = "";
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("friday.in"));
			out = new PrintWriter(new File("friday.out"));
			init();
			result = solve();
			
			out.println(result);
			out.close();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void init() {
		years = Integer.parseInt(in.nextLine());
		current = 1900;
		week = new int[7]; // week[0] = Monday
	}
	public static String solve() {
		int day = 0;
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int x = current; x < years + current; x++) {
			for(int y = 0; y < 12; y++) {
				week[(day+13) % 7] ++;
				if (y==1 && leapYear(x)) {
					day++;
				}
				day+= month[y];
			}
		}
		return week[6] + " " + week[0] + " " + week[1] + " " + week[2] + " " + week[3] + " " + week[4] + " " + week[5];		
	}
	public static boolean leapYear(int x) {
		if(x % 4 == 0 && (x%100 !=0 || x %400 == 0)) {
			return true;
		}else {
			return false;
		}
	}
}
