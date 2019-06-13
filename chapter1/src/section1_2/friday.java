/*
ID: ccho2011
LANG: JAVA
TASK: friday
*/
package section1_2;
import java.util.*;
import java.io.*;
public class friday {
	static Scanner in;
	static PrintWriter out;
	static String inFile = "friday.in";
	static String outFile = "firday.out";
	static int years;
	static int current;
	static int day;
	static int a ;
	static int[] week; 
	static String result = "";
	public static void main(String[] args) {
		try {
			in = new Scanner(new File(inFile));
			out = new PrintWriter(new File(outFile));
			init();
			result = solve();
			
			out.println(result);
			out.close();
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private static void init() {
		years = Integer.parseInt(in.nextLine());
		current = 1900;
		day = 13;
		a = day % 7-1;
		week = new int[7]; // week[0] = Monday
	}
	public static String solve() {
		for(int x = 0; x < years; x++){	
			for(int y = 0; y < 12; y++){		
				a = day % 7-1;
				if(a <0){
					a= a+7;
				}
				week[a]++;
				if(y ==0 || y == 2 || y == 4 || y== 6|| y==7||y==9|| y==11){
					day = day + 31;
				}else if(y== 1){ // February
					if(current%400 == 0){ // leap year logic
						day=day+29;
					}else if(current %4 ==0 && current%100 !=0 ){ 
						day=day+29;
					}
					else{
						day = day + 28;
					}
				}else{
					day = day + 30;
				}
			}
			current++;
		}
	}
}
