package day14;
import java.util.*;
public class cowjog {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] line = new int[n];
		for(int i = 0;i < n; i++) {
			in.nextInt();
			line[i] = in.nextInt();
		}
		int total = n; 
		int previous= -1;
		for(int i = n-1; i >= 0; i--) {
			if(i == n-1) {
				previous = line[i];
			}
			else if(previous < line[i]) {
				total--;
			}
			else if(previous >= line[i]) {
				previous = line[i];
			}
		}
		System.out.println(total);
		
		
	}
}

