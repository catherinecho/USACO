package hspc2018;

import java.util.Scanner;

public class islandhopping {
	static boolean check = false;
	static String islandHopping(int n,int[] nums) {
		dfs(0, nums);
		if(check == true) {
			return "TRUE";
		}
		return "FALSE";
	}
	
/*------------DO NOT EDIT UNDER THIS LINE------------*/
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[] nums=new int[n];
		
		for(int i=0;i<n;i++)
			nums[i]=sc.nextInt();
		
		System.out.println(islandHopping(n,nums));
	}
	public static void dfs(int i, int[] nums) {
		if(nums[i] == 0) {
			return;
		}
		if(i == nums.length-1) {
			check = true;
			return;
		}
		for(int x = 1; x <= nums[i]; x++) {
			int cur = i + x;
			if(valid(cur, nums.length)) {
				dfs(cur, nums);
			}
			if(check == true) {
				return;
			}
		}
	}
	public static boolean valid(int cur, int length) {
		if(cur < length) {
			return true;
		}
		return false;
	}
}
