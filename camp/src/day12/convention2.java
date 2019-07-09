package day12;
import java.util.*;
public class convention2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<hi> pq = new PriorityQueue<hi>();
		ArrayList<hi> c= new ArrayList<hi>();
		timeCompare tc = new timeCompare();
		for(int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			c.add(new hi(a,b,i));
		}
		Collections.sort(c, tc);
		int ans = 0;
		hi active = c.get(0);
		int nr = 1;
		int fin = active.start+active.time; 
		while(nr < n || pq.size()> 0) {
			while(nr < n && c.get(nr).start <= fin) {
				pq.add(c.get(nr));
				nr++;
			}
			if(nr < n && pq.size() == 0) {
				fin = c.get(nr).start + c.get(nr).time;
				nr++;
			}
			else if(pq.size()> 0) {
				hi t = pq.remove();
				ans = Math.max(ans,  fin- t.start);
				fin = fin + t.time;
			}
		}
		System.out.println(ans);
	}
}

class hi implements Comparable<hi>{
	int start;
	int time;
	int ind;
	public int compareTo(hi x) {
		return this.ind - x.ind;
	}
	
	public hi(int s, int t, int i) {
		this.start= s;
		this.time = t;
		this.ind = i;
	}
	
	public int getS() {return start;}
	public int getE() {return time;}
	public int getI() {return ind;}
	
}

class timeCompare implements Comparator<hi>{
	public int compare(hi a, hi b) {
		if(a.start == b.start) {
			return a.ind - b.ind;
		}else {
			return a.start - b.start;
		}
	}
}
