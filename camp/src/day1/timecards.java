package day1;
import java.util.*;
import java.io.*;
public class timecards {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int cownum = in.nextInt();
		int lines = in.nextInt();
		int[] cows = new int[cownum];
		int[] time = new int[cownum];
		
		for(int x= 0; x < lines; x++) {
			int c = in.nextInt();
			String w = in.next();
			int hr = in.nextInt();
			int min = in.nextInt();
			if(w.equals("START")) {
				cows[c-1] = (hr*60) + min;
			}else {
				time[c-1] += ((hr*60) + min) - cows[c-1];
			}
			
		}
		
		
		for(int i = 0; i < cownum; i++) {
			System.out.println(time[i] / 60 + " " + time[i] % 60);
		}
	}
}
