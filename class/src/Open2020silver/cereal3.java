package Open2020silver;
import java.util.*;
import java.io.*;
public class cereal3 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("cereal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] firstChoice = new int[n];
		int[] secondChoice = new int[n];
		int[] next = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			firstChoice[i] = Integer.parseInt(st.nextToken());
			secondChoice[i] = Integer.parseInt(st.nextToken());
			next[i] = secondChoice[i];
		}
		
		int[] curOwner = new int[m+1];
		for(int i = 0; i <= m; i++) {
			curOwner[i] = -1;
		}
		
		int[] ans = new int[n];
		int curAns = 0;
		for(int i=n-1; i >=0;i--) {
			int cow = i;
			int cereal = firstChoice[i];
			boolean foundPosition = true;
			if(curOwner[cereal]!= -1) {
				while(curOwner[cereal] != -1) {
					
					if(cow < curOwner[cereal]) {
						if(cow == i) {
							next[cow] = secondChoice[cow];
						}else {
							next[cow] = -1;
						}
						int temp  = curOwner[cereal];
						curOwner[cereal] = cow;
						cow = temp;
						cereal = next[cow];
						if(cereal == -1) {
							foundPosition = false;
							break;
						}
					}else if(cow > curOwner[cereal]) {
						foundPosition = false;
						break;
					}
				}
				if(foundPosition) {
					curOwner[cereal] = cow;
					next[cow] = -1;
				}
			}else {
				curOwner[cereal] = cow;
				next[cow] = secondChoice[cow];
			}
			
			if(foundPosition) {
				curAns++;
				
			}
			ans[i] = curAns;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(ans[i]);
		}
	}
}
