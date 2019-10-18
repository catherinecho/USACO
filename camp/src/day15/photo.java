package day15;
import java.util.*;


public class photo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		ArrayList <Integer> visited = new ArrayList<Integer>();
		p[] photos= new p[k*2+1];
		for(int i = 1; i <= 2*k; i++) {

			if(i %2 ==1) {
				photos[i] = new p(in.nextInt(),i/2+1);
				
			}else {
				photos[i] = new p(in.nextInt(), i/2);
			}
		}
		
		Arrays.sort(photos, 1,2*k+1);
		System.out.println(visited);
		for(int i = 1; i <= 2*k; i++) {
			System.out.println(photos[i].num + " " + photos[i].ind);
		}
		for(int i =1; i <= 2*k; i++) {
			 
		}
	}
		
}

class p implements Comparable<p>{
	int num;
	int ind;
	public int compareTo(p m) {
		return this.num - m.num;
	}
	public p(int n, int i) {
		this.num= n;
		this.ind = i;
	}
}