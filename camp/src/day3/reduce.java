package day3;
import java.util.*;
public class reduce {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cownum = in.nextInt();
		points[] p = new points[cownum];
		for(int i = 0; i < cownum; i++) {
			p[i] = new points(in.nextInt(), in.nextInt());
		}
		//max
		int x1 =0;
		int x2 =0;
		int y1=0;
		int y2=0;
		//min
		int x3= p[0].x;
		int x4 =p[0].x;
		int y3 = p[0].y;
		int y4 = p[0].y;
		
		for(int i = 0; i < cownum; i++) {
			if(p[i].x < x1) {
				x2= x1;
				x1 = p[i].x;
			}else if(p[i].x<x2) {
				x2 = p[i].x;
			}
			
			if(p[i].x > x4) {
				x3 = x4;
				x4 = p[i].x;
			}else if(p[i].x > x3){
				x3 = p[i].x;
			}
			
			
			if(p[i].y < y1) {
				y2= y1;
				y1 = p[i].y;
			}else if(p[i].y<y2) {
				y2 = p[i].y;
			}
			
			if(p[i].y > y4) {
				y3 = y4;
				y4 = p[i].y;
			}else if(p[i].y > y3){
				y3 = p[i].y;
			}
		}
		int xmax = 0;
		int xmin = 0;
		int ymax = 0;
		int ymin=0;
		int ans = (x4 - x1)* (y4-y1);
		for(int i = 0; i < cownum; i++) {
			xmin = x1;
			if(p[i].x == x1) {
				xmin =x2;
			}
			xmax = x4;
			if(p[i].x ==x4){
				xmax = x3;
			}
			ymin = y1;
			if(p[i].y == y1) {
				ymin = y2;
			}
			ymax = y4;
			if(p[i].y == y4) {
				ymax = y3;
			}

		}
		System.out.println(ans);
		System.out.println(ymin);
		ans = Math.min(ans, (xmax-xmin)*(ymax-ymin));
		System.out.println(ans);
		
		
		
	}
}
class points{
	int x;
	int y;
	public points(int X, int Y) {
		this.x = X;
		this.y = Y;
	}
	public int getX() {return x;}
	public int get() {return y;}
}
