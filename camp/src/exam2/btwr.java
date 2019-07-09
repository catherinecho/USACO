package exam2;
import java.util.*;

public class btwr {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static ArrayList<hi> hay = new ArrayList<hi>();
	public static void main(String[] args) {
		for(int i = 0; i < n; i++) {
			hay.add(new hi(in.nextInt(), in.nextInt()));
		}
		Collections.sort(hay);
		int change = 1;
		while(change != 0) {
			change= 0;
			for(int i = 0; i < hay.size()-1; i++){
				if(hay.get(i).breadth < hay.get(i+1).breadth) {
					hay.remove(i);
					i = i -1;
					change++;
				}
			}
		}
		
				
			/*
				}
		for(int i= hay.size()-1; i>0; i--) {
			
			if(hay.get(i).width < hay.get(i-1).width && hay.get(i).breadth > hay.get(i-1).breadth) {
				hay.remove(i);
				Collections.sort(hay);
			}
			
			 if(hay.get(i).breadth > hay.get(i-1).breadth) {
				hay.remove(i-1);
				
			}
			
			else if(hay.get(i).width > hay.get(i-1).width && hay.get(i).breadth < hay.get(i-1).breadth) {
				hay.remove(i-1);
			}
			
		}
		*/
		for(int i = 0 ; i < hay.size(); i++) {
			System.out.println(hay.get(i).width + " " + hay.get(i).breadth);
			
		}
		
		
		System.out.println(hay.size());
		
	}
}
class hi implements Comparable<hi>{
	int width;
	int breadth;
	public int compareTo(hi m) {
		if( m.width - this.width > 0 ) {
			if(m.breadth - this.breadth >0) {
				return 1;
			}else {
				return 1;
			}
			
		}
		/*
		 * && m.breadth - this.breadth> 0
		else if( m.width - this.width > 0 && m.breadth - this.breadth < 0 ){
			return -1;
		}else if (m.width - this.width < 0 && m.breadth - this.breadth> 0  ){
			return 1;
		}
		*/else {
			return -1;
		}
		
	}
	public hi(int w, int b) {
		this.width = w;
		this.breadth = b;
	}
	public int getW() {return width;}
	public int getB() {return breadth;}
	
}