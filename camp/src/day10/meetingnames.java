package day10;
import java.util.*;
public class meetingnames {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> names = new HashMap<String, Integer>();
		int n = in.nextInt();
		for(int i = 0; i <= n; i++) {
			String a = in.nextLine();
			if(!names.containsKey(a)) {
				names.put(a, 1);
			}else {
				names.put(a, names.get(a) + 1);
			}
		}
		int max = 0;
		String ans = "";
		
		
		for(Map.Entry<String, Integer> i: names.entrySet()) {
			if( max < i.getValue()) {
				max = i.getValue();
				ans = i.getKey(); 
			}
		}
		
		System.out.println(ans + " " + max);
	}
}
