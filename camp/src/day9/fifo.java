package day9;
import java.util.*;
public class fifo {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static Queue<Integer>[] list = new LinkedList[n];
	static Queue<Integer> c = new LinkedList<Integer>();
	static Queue<Integer>[] d = new LinkedList[10];
	public static void main(String[]args) {
		
		for(int i=0; i<10; i++)
			d[i] = new LinkedList<Integer>();
		
		while(in.hasNext()) {
			String s = in.next();
			int nr = in.nextInt();
			
			if(s.equals("C")) {
				c.add(nr);
			}else {
				d[nr].add(c.remove());
			}
		}
		
		for(int i = 0; i < d.length; i++) {
		    if(d[i].size() > 0){
    			while(d[i].size() > 0) {
    				System.out.print(d[i].remove()+" ");
    			}
    			System.out.println();
		    }
		}
		
	}
}
