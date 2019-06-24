package day1;
import java.util.*;
import java.io.*;
public class bones {
	static Scanner in = new Scanner(System.in);
	static int d1; 
	static int d2;
	static int d3;
	
	public static void main(String[] args) {
		try {
			init();
			
			System. out.print(solve());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void init() {
		d1 = in.nextInt();
		d2 = in.nextInt();
		d3 = in.nextInt();
		
	}
	public static String solve() {
		
		HashMap<Integer, Integer> s = new HashMap<Integer,Integer>();
		HashSet<Integer> nums = new HashSet<Integer>();
		for(int i =1 ; i <= d1; i++) {
			for(int j = 1; j <= d2; j++) {
				for(int z = 1; z <= d3; z++) {
						int sum = 0;
						sum = i + j + z;
						nums.add(sum);
						if(s.containsKey(sum)) {
							s.put(sum,s.get(sum) + 1);
						}else {
							s.put(sum,1);
						}
						
				}
			}
		}
		
		int max =0;
		String clone = nums.toString();
		clone = clone.substring(1,clone.length()-1);
		String[] n = clone.split(", ");
		
		for(int i = n.length-1; i > 0; i--) {
			if(s.get(Integer.parseInt(n[i])) < s.get(Integer.parseInt(n[i-1]))) {
				s.remove(Integer.parseInt(n[i]));
				max = Integer.parseInt(n[i-1]);
				continue;
			}
			if(s.get(Integer.parseInt(n[i])) == s.get(Integer.parseInt(n[i-1]))) {
				
				max = Math.min(Integer.parseInt(n[i]), Integer.parseInt(n[i-1]));
				s.remove(Math.max(Integer.parseInt(n[i]), Integer.parseInt(n[i-1])));
			}
		}
		
		return Integer.toString(max);
	}
	
}
