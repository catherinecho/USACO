package day2;
import java.util.*;
public class secpas {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] m = new int[N+1];

		for(int i=0; Math.pow(i, 2)<=N; i++){
			for(int j=0; Math.pow(j, 2)<=N; j++){
				if(Math.pow(i, 2)+Math.pow(j, 2)<=N){
					m[(int)(Math.pow(i, 2)+Math.pow(j, 2))]++;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<=N; i++){
			ans+=m[i]*m[N-i];
		}
		System.out.println(ans);
	}
}
