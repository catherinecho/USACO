package exam1;
import java.io.*;
import java.util.*;
public class growingcomp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		list[] lastyear = new list[n];
		list[] thisyear = new list[n];
		HashMap<String, Integer> diff = new LinkedHashMap<String, Integer>();
		for(int i = 0 ; i < n; i++) {
			
			lastyear[i]= new list(in.next(), in.nextInt());
			
		}
		Arrays.sort(lastyear);
		for(int i = 0 ; i < n; i++) {
			String comp= in.next();
			thisyear[i]= new list(comp, i + 1);
			diff.put(comp,0);
		}
		for(int i = 0; i < n; i++) {
			boolean x = false;
			for(int j = 0; j < n; j++) {
				if(lastyear[i].company.equals(thisyear[j].company)) {
					diff.put(lastyear[i].company, lastyear[i].rank - thisyear[j].rank);
					//System.out.println(thisyear[i].company + " " +  thisyear[i].rank);
					x = true;
					break;
				}else if(!lastyear[i].company.equals(thisyear[j].company) && j == n-1){
					//System.out.println(thisyear[i].company + " " +  thisyear[i].rank);
					diff.put(thisyear[i].company, n - thisyear[i].rank + 1);
					//System.out.println(thisyear[i].rank);
					diff.remove(lastyear[i].company);
				}
			}
			
		}
		int max = 0;
		int maxindex = 0;
		String ans = "";
		for(int i = 0; i < diff.size(); i++) {
			if(diff.get(thisyear[i].company) > max) {
				max = diff.get(thisyear[i].company);
				maxindex = i;
				ans = thisyear[i].company;
			}
			else if (diff.get(thisyear[i].company) == max) {
				System.out.println(thisyear[maxindex].company);
				System.out.println(thisyear[i].company);
				ans = thisyear[maxindex].company;
			}
		}
		System.out.println(ans);
		
	}
	
}

class list implements Comparable<list>{
	String company;
	int rank;
	
	
	@Override
	public int compareTo(list l){
		if(this.rank < l.rank){
			return -1;
		}
		else
			return 1;
		
	}
	public list( String c, int r){
		this.rank = r;
		this.company = c;
	}
	public int getR() { return rank; }
	public String getC() { return company; }
}
