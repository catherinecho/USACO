package Jan2019silver;
import java.util.*;
import java.io.*;
public class mountains {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("mountains.in"));
		PrintWriter out = new PrintWriter(new File("mountains.out"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		coordinate points[] = new coordinate[n];
		for(int i =0 ; i < n; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			points[i] = (new coordinate(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken())));
		}
		int ans = n;
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				int changeX = Math.abs(points[j].x - points[i].x);
				int changeY = (points[j].y - points[i].y);
				if(changeX <= changeY) {
					ans--;
					break;
				}
			}
		}
		/*
		ArrayList<coordinate> points = new ArrayList<coordinate>();
		for(int i =0 ; i < n; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			points.add(new coordinate(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken())));
		}
		for(int i = points.size()-1; i >= 0; i--) {
			for(int j = points.size()-1; j >= 0; j--) {
				if(i==j) {
					continue;
				}
				double slope = (double)(points.get(i).y - points.get(j).y) / (double)(points.get(i).x - points.get(j).x);
				if(slope > 1.0 || slope <-1.0) {
					if((double)(points.get(i).y - points.get(j).y) > 0) {
						points.remove(j);
					}
					
				}
			}
		}
		*/
		/*
		for(int i = 0; i < points.size(); i++) {
			System.out.println(points.get(i).x + " " + points.get(i).y);
		}
		*/
		out.println(ans);
		out.close();
		in.close();
	}
}
class coordinate{
	int x;
	int y;
	public coordinate(int X, int Y) {
		x = X;
		y = Y;
	}
}