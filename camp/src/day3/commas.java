package day3;
import java.util.*;
public class commas {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int number = in.nextInt();
		String s = number+"";
		String ans = "";
		int count = 0;
		for(int i=s.length()-1; i>=0; i--){
			if(count==3){
				ans=","+ans;
				count=0;
			}
			ans = s.charAt(i)+ans;
			count++;
		}
		System.out.println(ans);
	}
}
