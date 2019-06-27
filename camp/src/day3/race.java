package day3;
import java.util.*;
public class race {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		ArrayList<results> times = new ArrayList<results>();
		for(int i = 0; i < num; i++) {
			times.add(new results (in.nextInt(), in.nextInt(), in.nextInt()));
		}
		Collections.sort(times);
		for(int i = 0; i < times.size(); i++) {
			System.out.println(times.get(i).getHr()+" " + times.get(i).getMin() + " " + times.get(i).getSec());
		}
	}
}
class results implements Comparable<results>{
	private int hr;
	private int min;
	private int sec;
	public int compareTo(results m) {
		if( this.hr - m.hr != 0) {
			return this.hr - m.hr;
		}else {
			if(this.min - m.min != 0) {
				return this.min - m.min;
			}else {
				return this.sec - m.sec;
			}
		}
		
	}
	public results(int h, int m, int s) {
		this.hr = h;
		this.min = m;
		this.sec = s;
	}
	public int getHr() {return hr;}
	public int getMin() {return min;}
	public int getSec() {return sec;}
	
}
