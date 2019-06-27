package day3;
import java.util.*;
public class censor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.next();
		String x = in.next();
		int change = 1;
		while(true) {
			String temp = word;
			word = word.replace(x, "");
			if(temp.equals(word)) {
				change++;
				break;
			}
		}
		System.out.println(word);
	}
}
