package section1_2;
import java.io.*;
import java.util.*;
public class ride {
	static Scanner in = new Scanner(System.in);
	static String result = "";
	static String[] input;
	public static void main(String[] args) {
		try {
			init();
			result = solve();
			System.out.println(result);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private static void init() {
		input = new String[2];
		input[0] = in.nextLine();
		input[1] = in.nextLine();
	}
	private static String solve() {
		int n1 = convert(input[0]);
		int n2 = convert(input[1]);
		if(n1 == n2) {
			return "GO";
		}
		return "STAY";
		
	}
	public static int convert(String name) {
		int ans =1;
		for(int i = 0; i < name.length(); i++) {
			int c = name.charAt(i) - 'A' + 1;
			ans = ans * c;
		}
		ans = ans %47;
		return ans; 
	}
}
