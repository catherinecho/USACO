package section1_2;
/*
ID: ccho2011
LANG: JAVA
TASK: beads
 */
import java.util.*;
import java.io.*;
public class beads {
	static Scanner in;
	static PrintWriter out;
	static int size;
	static String necklace;
	static int left = 0;
	static int right = 0;
	static int sum = 0;
	static int max = sum;
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("beads.in"));
			out = new PrintWriter(new File("beads.out"));
			init();
			out.print(solve());
			out.close();
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private static void init() {
		size = Integer.parseInt(in.nextLine());
		necklace = in.nextLine();
		necklace = necklace + necklace;
	}	
	public static String solve() {
		for(int i = 1; i <=size; i++){
			left = 0;
			right = 0;
			String l = necklace.substring(0,i);
			String r = necklace.substring(i);
			char letterL = l.charAt(l.length()-1);
			char letterR = r.charAt(0);
			for(int x = l.length()-1; x >= 0; x--){
				if(letterL == 'w' && l.charAt(x) != letterL) {
					letterL = l.charAt(x);
					left++;
				}

				else if(letterL == l.charAt(x)) {
					left++;
				}else if(l.charAt(x)=='w'){
					left++;
				}
				else {
					break;
				}
			}
			for(int x = 0; x < r.length(); x++){
				if(letterR == 'w' && r.charAt(x) != letterR) {
					letterR = r.charAt(x);
					left++;
				}

				else if(letterR == r.charAt(x)) {
					right++;
				}else if(r.charAt(x) == 'w') {
					right++;
				}
				else {
					break;
				}
			}
			sum = right + left;
			if(sum > max) {
				max = sum;
			}
		}
		max = Math.min(max, size);
		return Integer.toString(max);
	}
}
