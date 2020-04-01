package Feb2020bronze;
import java.util.*;
import java.io.*;
public class triangles {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("triangles.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<dot> xax = new ArrayList<dot>();
		ArrayList<dot> yax = new ArrayList<dot>();
		ArrayList<dot> none = new ArrayList<dot>();
		ArrayList<dot> points = new ArrayList<dot>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new dot(x,y));
		}
		double ans = 0.0;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				for(int k =j+1 ; k < n; k++){
					double changeY1 =Math.abs(( points.get(i).y - points.get(j).y));
					double changeX1 = Math.abs(( points.get(i).x - points.get(j).x));
					double changeY2 =Math.abs(( points.get(k).y - points.get(j).y));
					double changeX2 = Math.abs(( points.get(k).x - points.get(j).x));
					double changeY3 =Math.abs(( points.get(i).y - points.get(k).y));
					double changeX3 = Math.abs(( points.get(i).x - points.get(k).x));
					double height = 0.0;
					double base = 0.0;
					if(changeX1 == 0){
						height = changeY1;
					}else if (changeX2 ==0){
						height = changeY2;
					}else if(changeX3 ==0) {
						height = changeY3;
					}
			
					if(changeY1 == 0){
						base = changeX1;
					}else if(changeY2 == 0){
						base = changeX2;
					}else if(changeY3 == 0) {
						base = changeX3;
					}
					
					ans = Math.max(ans, base * height);
				}
			}
		}
		System.out.println(ans);
		
		
	}
	public static double area(dot A, dot B, dot C) {
		double area = (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2.0;
		return area;
	}
}
class dot implements Comparable<dot>{
	int x;
	int y;
	public dot(int X, int Y) {
		x = X;
		y = Y;
	}
	public int compareTo(dot m) {
		if(m.x < x) {
			return 1;
		}else {
			return -1;
		}
	}
}