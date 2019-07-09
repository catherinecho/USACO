package exam1;
import java.util.*;
public class bookshelf2 {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int shelf = in.nextInt();
	static int ans = shelf;
	static int[] cows = new int[n];
	static int[] combo = new int[n+ 1];
	public static void main(String[] args) {
		for(int i = 0; i < n+ 1; i++) {
			combo[i] = -1;
		}
		for(int i = 0; i < n; i++) {
			cows[i] = in.nextInt();
		}
		for(int i = 1; i <=n; i++) {
			f(1, i);
		}
		System.out.println(ans);
		
	}
	public static void f(int x, int y) {
		if(x == y+1) {
			if(valid()) {
				int temp = 0;
				//System.out.println(Arrays.toString(combo));
				for(int i = 1; i <= n; i++) {
					if(combo[i] == -1) {
						continue;
					}
					
					temp += cows[combo[i]];
				}
				//System.out.println(Arrays.toString(combo) + " " +temp);
				
				if(temp - shelf >= 0) {
					//System.out.println(Arrays.toString(combo) + "  " + temp);
					
					if(temp - shelf < ans) {
						
						ans = temp - shelf;
					}
					
				}
				
				
			}
			return;
		}
		for(int i = 0; i < n; i++) {
			combo[x] = i ;
			f(x+ 1, y);
		}
		
	}
	public static boolean valid() {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i <= n; i++) {
			if(combo[i] == -1) {
				continue;
			}
			if(!map.containsKey(combo[i])) {
				map.put(combo[i], 1);
			}else {
				return false;
			}
		}
		return true;
	}
}
