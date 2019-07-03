package day7;
import java.util.*;
public class stringpermutation {
	static Scanner in = new Scanner(System.in);
	static String word  = in.next();
	static int n = word.length();
	static char[] word2 = new char[n];
	static int count = 0;
	static char[] a = new char [n+ 1];
	static char[] b = new char[n];
	static char[] c = b.clone();
	public static void main(String[] args) {
		for(int i = 0; i < n; i++) {
			b[i]  = word.charAt(i);
			c[i] = b[i];
			word2[i] = b[i];
		}
		Arrays.sort(word2);
		
		f(1);
	}
	public static void f(int x) {
		if(x == n+1) {
			
			if(valid()) {
				for(int i = 1; i < n+1; i++) {
					System.out.print(a[i]);
				}
				System.out.println();
				count++;
			}
			return;
		}
		for(int i = 0; i <n; i++) {
			a[x] = word2[i];
			f(x+1);
		}
	}
	public static boolean valid() {
		for(int i = 0; i < n; i++) {
			b[i] = c[i];
		}
		for(int i = 1; i < n+1; i++) {
			for(int j = 0; j < n; j++) {
				if(b[j] == a[i]){
					
					b[j] = '0';
					break;
				}
			}
		}
		
		for(int j = 0; j < n; j++) {
			if(b[j] != '0') {
				return false;
			}
		}
		return true;
		
	}
}

