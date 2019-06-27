package day2;
import java.io.*;
import java.util.*;
public class gift1 {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int NP = Integer.parseInt(in.nextLine());
		StringTokenizer st;
		Map<String,Integer> m = new LinkedHashMap <String,Integer>();
		for(int i = 0; i < NP; i++) {
			m.put(in.nextLine(), 0);
		}
		 
		for(int x = 0; x < NP; x++) {
			String giver = in.nextLine();
			st = new StringTokenizer(in.nextLine());
			int money = Integer.parseInt(st.nextToken());
			int ppl = Integer.parseInt(st.nextToken());
			if(ppl == 0) {
				continue;
			}
			m.put(giver, m.get(giver) - money);
			int give = money / ppl;
			int remainder= money%ppl;
			for(int i = 0; i < ppl; i++){
				String name = in.nextLine();
				m.put(name, m.get(name)+ give);
			}
			m.put(giver,m.get(giver) + remainder);
					
		}
		for(String s: m.keySet()) {
			System.out.println(s + " " + m.get(s));
		}
		
		
	}
	
}
