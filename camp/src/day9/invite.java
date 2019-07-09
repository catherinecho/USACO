package day9;
import java.util.*;
public class invite {
	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		int c = in.nextInt();
		int groupsize = in.nextInt();
		HashSet<Integer>[] groups = new HashSet[groupsize];
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < groupsize; i++) {
			int s = in.nextInt();
			for(int j = 0; j < s; j++ ) {
				int b= in.nextInt();
				groups[i]= new HashSet<Integer>();
				groups[i].add(b);
				/*
				if(i==0 && j==0) {
					q.add(b);
				}
				*/
				
			}
		}
		q.add(1);
		//int cur = q.remove();
		int ans = 1;
		while(!q.isEmpty()) {
			int t = q.remove();
			for(int i = 0;i < groups.length; i++) {
				if(!groups[i].isEmpty()) {
				
					groups[i].remove(t);
					if(groups[i].size()==1) {
						if(!q.contains(groups[i].iterator().next())) {
							ans++;
							//System.out.println(groups[i].iterator().next());
							q.add(groups[i].iterator().next());
						}
						
					}
				}
			}
		}
		System.out.println(ans);
		/*
		for(int g = 0; g < groups.length; g++) {
			if(groups[g].contains(cur)) {
				groups[g].remove(cur);
				if(groups[g].size()==1) {
					System.out.println("hi");
					ans++;
					q.add(groups[g].first());
				}
			}
		}
		*/
	}
}
