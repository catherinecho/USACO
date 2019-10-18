package exam3;
import java.util.*;
public class catchcow {
	static Scanner in = new Scanner(System.in);
	static int start = in.nextInt();
	static int end=  in.nextInt();
	
	public static void main(String [] args) {
	
		if(start == end) {
			System.out.println(0);
			return;
		}
		if(start == 0) {
			System.out.println(end);
			return;
		}
		Queue<cows> q = new LinkedList<cows>();
		q.add(new cows(start, 0));
		while(!q.isEmpty()) {
			cows cur=  q.remove();
			
			if(cur.nr == end) {
				System.out.println(cur.steps);
				return;
			}
			if(cur.nr-1 >= 1) {
				q.add(new cows(cur.nr-1, cur.steps+1));
			}
				q.add(new cows(cur.nr+1,cur.steps+1));
			q.add(new cows(cur.nr* 2, cur.steps+1));
		}
		
	}
	
	
}
class cows{
	int nr;
	int steps;
	public cows(int n, int s) {
		this.nr = n;
		this.steps = s;
	}
}