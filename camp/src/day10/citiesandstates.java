package day10;
import java.util.*;
public class citiesandstates {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		HashMap<String, Integer> cs = new HashMap<String, Integer>();
		for(int i= 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.nextLine());
			String  city = st.nextToken();
			String state = st.nextToken();
			if(!city.substring(0,2).equals(state)) {
				String k = city.substring(0,2)+ state;
				if(!cs.containsKey(k)) {
					cs.put(k, 1);
				}else {
					cs.put(k, cs.get(k) + 1);
				}
			}
			
		}
		long ans = 0;
		for(String key: cs.keySet()) {
			
			String otherkey = key.substring(2) + key.substring(0,2);
			long x = cs.get(key);
			long y = 0;
			if(cs.containsKey(otherkey)) {
				y = cs.get(otherkey);
				
			}
			ans += x*y;
		}
		System.out.println(ans / 2);
	}
}
