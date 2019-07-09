package day9;
import java.util.*;
public class lookup {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static Stack<hi> s = new Stack<hi>();
	static int[] ans = new int[n+1];
	static hi[] a= new hi[n+1];
 	public static void main(String[] args) {
		for(int i = 1; i <= n; i++) {
			int b = in.nextInt();
			a[i] = new hi(i, b);
		}
		for(int i = 1; i <= n;i++) {
			while(!s.isEmpty() && s.peek().height< a[i].height) {
				ans[s.peek().index] = i;
				s.pop();
			}
			s.push(a[i]);
		}
		while(!s.isEmpty()) {
			ans[s.peek().index] = 0;
			s.pop();
		}
		for(int i = 1; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
class hi{
	int index;
	int height;
	public hi(int i, int h) {
		this.index = i;
		this.height = h;
	}
	public int getI() {return index;}
	public int getH() {return height;}
}
