package day14;
import java.util.*;
public class iou {
	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int[] money = new int[n];
	static int b = 0;
	static int ans=  0;
	public static void main(String[] args) {
		int totaldebt = 0;
		for(int i = 0; i < n; i++) {
			int a = in.nextInt();
			
			money[i] = a;
		}
		int posfirstdebt = -1;
		for(int i = 0; i < n; i++) {
			ans++;
			if(money[i] > 0) {
				b+= money[i];
			}
			if(money[i] < 0) {
				if(posfirstdebt == -1) {
					posfirstdebt = i;
				}
				totaldebt += money[i] * -1;
			}
			if(b >= totaldebt && totaldebt!= 0) {
				b = b - totaldebt;
				totaldebt = 0;
				ans+= (i - posfirstdebt) * 2;
				posfirstdebt = -1;
			}
			
		}
		System.out.println(ans);
	}
}
