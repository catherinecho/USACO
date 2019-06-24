package day1;
import java.util.*;
import java.io.*;
public class outOfPlace {
	static Scanner in = new Scanner(System.in); 
	static PrintWriter out;
	static int num;
	static ArrayList<Integer> cows;
	static int count; 
	static int bessieIndex; 
	public static void main(String[] args) {
		try {
			init();
			
			System. out.print(solve());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void init() {
		num = in.nextInt();
		cows = new ArrayList<Integer>();
		for(int i = 0; i < num; i++) {
			cows.add(in.nextInt());
		}
		
		for(int i = cows.size() -1; i > 0; i--) {
			int one = cows.get(i); 
			int two = cows.get(i-1);
			if(one == two) {
				cows.remove(i);
			}
		}
		
		for(int i = 0; i < num-1; i++) {
			if(i > 1 && cows.get(i) < cows.get(i - 1) && cows.get(i) < cows.get(i-2) ) {
				bessieIndex = i;
				break;
			}
			else if(i!= 0 && cows.get(i) > cows.get(i+1) && cows.get(i+ 1) >= cows.get(i-1)) {
				bessieIndex = i;
				break;
				
			}
		}
	}
	public static String solve() {
		int bessie = cows.get(bessieIndex);
		if(cows.get(bessieIndex) < cows.get(bessieIndex - 1)) {
			while(cows.get(bessieIndex) < cows.get(bessieIndex - 1)) {
				count++;
				cows.remove(bessieIndex);
				cows.add(bessieIndex - 1, bessie);
				bessieIndex = bessieIndex -1;
			}
		}else {

			while(cows.get(bessieIndex) > cows.get(bessieIndex + 1)) {
				count++;
				cows.remove(bessieIndex);
				cows.add(bessieIndex + 1, bessie);
				bessieIndex = bessieIndex +1;
			}
			
		}
		String ans = Integer.toString(count); 
		return ans;
	}
	
}
