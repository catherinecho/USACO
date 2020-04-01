package Open2017;
import java.io.*;
import java.util.*;
public class cownomics {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("cownomics.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m =  Integer.parseInt(st.nextToken());
		String[] spotty = new String[n];
		String[] plain = new String[n];
		int ans = 0;
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(in.readLine());
			spotty[i] = st.nextToken();
		}
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(in.readLine());
			plain[i] = st.nextToken();
		}
		for(int i = 0; i < m; i++){
			for(int j = i + 1; j < m; j++) {
				for(int k = j + 1; k < m; k++){
					HashMap<Integer, Boolean> compare = new HashMap<Integer, Boolean>();
					for(int x= 0; x < n; x++){
						int num = (int)(((spotty[x].charAt(i) - 'A') * Math.pow(26,0)) + ((spotty[x].charAt(j) - 'A') * Math.pow(26,1)) + ((spotty[x].charAt(k) - 'A') * Math.pow(26,2)));
						if(compare.containsKey( num)){
							continue;
						}else{
							compare.put(num, true);
						}
	
					}
	
					for(int x = 0; x < n; x++){
						int num = (int)(((plain[x].charAt(i) - 'A') * Math.pow(26,0)) + ((plain[x].charAt(j) - 'A') * Math.pow(26,1)) + ((plain[x].charAt(k) - 'A') * Math.pow(26,2)));
						if(compare.containsKey(num)){
							break;
						}else{
							if( x == n-1){
								ans++;
							}
						}
					}
				}
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}

}
