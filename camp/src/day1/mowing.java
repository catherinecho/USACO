package day1;

import java.io.*;
import java.util.*;

public class mowing {
	static Scanner in = new Scanner (System.in);
	static int n;
	static int [][] field = new int [2000][2000];
	static String[] direction;
	static int[] steps;

	public static void main(String[] args) {
		try {
			init();
			System.out.println(solve());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void init () {
		n = in.nextInt();
		direction = new String[n];
		steps = new int[n];
		for(int i = 0; i < n; i++) {
			direction[i] = in.next();
			steps[i] = in.nextInt();
		}
	}

	public static int solve () {
		ArrayList<Integer> inter = new ArrayList<Integer>();
		int intersect1 = 0;
		int intersect2 = 0;
		int cx = 1000;
		int cy = 1000;
		int a = 1;
		for(int i = 0; i < n; i++) {
			if(direction[i].equals("N")) {
				for(int j = 0; j < steps[i]; j++) {
					if(field[cx][cy+j] != 0) {
						intersect1 = field[cx][cy+j];
						intersect2 = a;
						field[cx][cy+j] = a;
						inter.add(intersect2 - intersect1);
					}else {
						field[cx][cy+j] = a;
					}

					a++;
				}
				cy += steps[i];
			}
		     else if(direction[i].equals("W")) {
		       for(int j = 0; j < steps[i]; j++) {
		         if(field[cx-j][cy] != 0) {
		           intersect1 = field[cx-j][cy];
		           intersect2 = a;
		           field[cx-j][cy] = a;
		           inter.add(intersect2 - intersect1);
		         }else {
		           field[cx-j][cy] = a;
		         }
		         a++;
		       }
		       cx -= steps[i];
		     }
		     else if(direction[i].equals("E")) {
		       for(int j = 0; j < steps[i]; j++) {
		         if(field[cx+j][cy] != 0) {
		           intersect1 = field[cx+j][cy];
		           intersect2 = a;
		           field[cx+j][cy] = a;
		           inter.add(intersect2 - intersect1);
		         }else {
		           field[cx + j][cy] = a;
		         }
		         a++;
		       }
		       cx += steps[i];
		     }else if(direction[i].equals("S")) {
		    	 	for(int j = 0; j < steps[i]; j++) {
		    	 		if(field[cx][cy-j]!=0) {
		    	 			intersect1 = field[cx][cy-j];
		    	 			intersect2 = a;
		    	 			field[cx+j][cy] = a;
		    	 			inter.add(intersect2 - intersect1);
		    	 		}else {
		    	 			field[cx][cy-j] = a;
		    	 		}
		    	 		a++;
		    	 	}
		    	 	cy -= steps[i];
		     }
			
		}
		if(inter.size() == 0) {
		      return -1;
		 }
		 int min = inter.get(0);
		 for(int i = 0; i < inter.size(); i++) {
		     if(min > inter.get(i)) {
		       min = inter.get(i);
		     }
		 }
		 return min;
	}
 }
