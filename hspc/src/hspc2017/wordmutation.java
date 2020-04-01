package hspc2017;

import java.util.Scanner;

public class wordmutation {
	
	static int wordMutation(int n,String[] words) {
		int ans = 0;
		for(int i = 0; i < n; i++) {
			String word = words[i];
			
			for(int j= 0; j < n; j++) {
				if(j ==i ) {
					continue;
				}
				String compare = words[j];
				int count = 0;
				for(int x = 0; x < word.length(); x++) {
					if(word.charAt(x) != compare.charAt(x)) {
						count++;
					}
				}
				if(count == 1) {
					ans++;
				}
			}
		}
		if(ans < n) {
			return 0;
		}
		return 1;
	}
	
/*------------DO NOT EDIT UNDER THIS LINE------------*/
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();sc.nextLine();
		String[] words=new String[n];
		
		for(int i=0;i<n;i++)
			words[i]=sc.nextLine();
		
		System.out.println(wordMutation(n,words));
	}

}
