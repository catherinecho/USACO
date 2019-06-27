package day4;
import java.util.*;
public class bcount {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] breed = new int[n];
		int q = in.nextInt();
		int[] one = new int[n+ 1];
		int[] two = new int[n+ 1];
		int[] three = new int[n + 1];
		for(int i = 1; i< n + 1; i++) {
			int a= in.nextInt();
			if(a == 1) {
				one[i] =one[i-1] + 1; 
			}
			else {
				one[i] = one[i-1];
			}
			if(a == 2) {
				two[i]  = two[i-1] + 1;
			}
			else {
				two[i] = two[i-1];
			}
			if (a == 3){
				three[i] = three[i-1] + 1;
			}
			else {
				three[i] = three[i-1];
			}
			
		}
		
		for(int i = 0; i < q; i++) {
			int s = in.nextInt();
			int f = in.nextInt();
			System.out.println((one[f] - one[s-1]) + " " + (two[f] - two[s-1]) + " " + (three[f] - three[s-1]));
		}
		
		
	}
}
