package day2;
import java.util.*;
public class cowmult {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String A = in.next();
		int[] a = new int[A.length()];
		for(int i = 0; i < a.length; i++) {
			a[i] = Character.getNumericValue(A.charAt(i));
		}
		String B = in.next();
		int[] b = new int[B.length()];
		for(int i = 0; i < b.length; i++) {
			b[i] = Character.getNumericValue(B.charAt(i));
		}
		int sum = 0;
		for(int i= 0; i < a.length; i++) {
			for(int j =0; j < b.length; j++) {
				sum = sum + (a[i] *b[j]);
			}
		}
		System.out.println(sum);
	}
}
