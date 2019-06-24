package day1;
import java.util.*;
import java.io.*;
public class counr {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int a= in.nextInt();
		String b= Integer.toString(a);
		char no;
		int count = 0;
		boolean yesNo = true;
		for(int i = 1; i < 2000000; i++) {
			String num = Integer.toString(i);
			
			for(int j = 0; j < num.length(); j++) {
				if(num.charAt(j) == b.charAt(0)) {
					yesNo = false;
					break;
				}
				else {
					yesNo = true;
				}
			}
			if(yesNo == false) {
				continue;
			}else {
				count++; 
				System.out.println(i);
				if(count == size) {
					System.out.println(i);
					break;
				}
				
			}
		}
		
	}
}
