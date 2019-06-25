package day2;
import java.util.*;
public class scavhunt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int one = in.nextInt();
		ArrayList<Integer> factor1 = new ArrayList<Integer>();
		int two = in.nextInt();
		ArrayList<Integer> factor2 = new ArrayList<Integer>();
		for(int i = 1; i <= one; i++) {
			if(one% i == 0) {
				factor1.add(i);
			}
		}
		for(int i = 1; i <= two; i++) {
			if(two% i == 0) {
				factor2.add(i);
			}
		}
		for(int i = 0; i < factor1.size(); i++) {
			for(int j = 0; j < factor2.size(); j++) {
				System.out.println(factor1.get(i) + " " + factor2.get(j));
			}
		}
	}
}
