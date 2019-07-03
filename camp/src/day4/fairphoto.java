package day4;
import java.util.*;

import day4.cow;
public class fairphoto {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		cow[] cows = new cow[n];
		for(int i = 0; i < n; i++) {
			cows[i] = new cow(in.nextInt(), in.next());
		}
		int[] p = new int[n+1];
		p[0] = 0;
		Arrays.sort(cows);
		
		int[] diff= new int[n];
		int g = 0;
		
		int h = 0;
		if(cows[0].breed.equals("G")) {
			g++;
		}else if(cows[0].breed.equals("H")) {
			h++;
		}
		diff[0] = Math.min(h, g) - Math.max(h, g);
		for(int i = 1; i < n; i++) {
			if(cows[i].breed.equals("G")) {
				g++;
			}else if(cows[i].breed.equals("H")) {
				h++;
			}
			diff[i] = Math.min(h, g) - Math.max(h, g);
			
		}
		int min = diff[0];
		for(int i =1 ;i < diff.length; i++) {
			if(diff[i] < min) {
				min = diff[i];
			}
		}
		min = Math.abs(min);
		
		for(int i =0 ;i < diff.length; i++) {
			diff[i] = diff[i] + min;
		}
		
		int[] st = new int [n];
		int[] fin = new int[n];
		for(int i = 0; i < st.length; i++) {
			st[i] = -1;
			fin[i] = -1;
		}
		
		for(int i = 0; i < n; i++) {
			if(st[diff[i]]== -1) {
				st[diff[i]] = 1;
			}
			fin[diff[i]] = i;
		}
		
		int ans = -1;
		for(int i = 0; i < n; i++) {
			if(fin[i] <= 0  || st[i] <= 0) {
				continue;
			}
			if(cows[fin[i]-1].location - cows[st[i]].location > ans) {
				ans = cows[fin[i]-1].location - cows[st[i]].location;
			}
		}
		System.out.println(ans);
		
		
	}
	
	
}
class cow implements Comparable <cow>{
	int location;
	String breed;
	public int compareTo(cow m) {
		if(this.location > m.location) {
			return this.location - m.location;
		}else {
			return -1;
		}
		
	}
	public cow(int l, String b) {
		this.location = l;
		this.breed = b;
	}
	public int getL() {return location;}
	public String getB() {return breed;}
}
