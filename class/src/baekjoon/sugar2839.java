package baekjoon;
import java.util.*;
import java.io.*;
public class sugar2839 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] list = new int[n+1];
		list[0] = 0;
		list[1] = -1;
		list[2] = -1;
		list[3] = 1;
		list[4] = -1;
		for(int i = 4; i < list.length; i++) {
			if( i >= 5) {
				if(list[i-3] == -1 && list[i-5] == -1){
					list[i] = -1;
				}else if (list[i-5] == -1){
					list[i] = list[i-3] + 1;
				}else if (list[i-3] == -1){
					list[i] = list[i-5] + 1;
				}else{
					list[i] = Math.min(list[i-3] + 1,  list[i-5] +1);
				}
			}
			
		}
		System.out.println(list[n]);
	}
}

