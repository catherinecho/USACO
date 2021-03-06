package Dec2017silver;
import java.util.*;
import java.io.*;
public class homework {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("homework.in"));
		PrintWriter out = new PrintWriter(new File("homework.out"));
		int n = Integer.parseInt(in.readLine());
		int[] homework = new int[n];
		int total = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {

			homework[i]= Integer.parseInt(st.nextToken());
			total+= homework[i];
		}
		int[] min = new int [n];
		for(int i = n-1; i>=0; i--) {
			if(i == n-1) {
				min[i] = homework[i];
			}else {
				min[i] = Math.min(min[i+1], homework[i]);
			}
		}
		//System.out.println(Arrays.toString(min));
		double avg = 0;
		int temp = 0;
		double num = n;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < n-2; i++) {
			temp += homework[i]; 
			num--;
			if((total - temp - min[i+1])/(num-1) > avg && avg !=(total - temp - min[i+1])/(num-1)) {
				avg = (total - temp - min[i+1])/(num-1);
				ans = new ArrayList<Integer>();
				ans.add(i+1);
			}else if(avg ==(total - temp - min[i+1])/(num-1)) {
				ans.add(i+1);
			}
			
			//System.out.println((total - temp)/num);
		}
		for(int i = 0; i < ans.size(); i++) {
			out.println(ans.get(i));
		}
		in.close();
		out.close();
	}
}
