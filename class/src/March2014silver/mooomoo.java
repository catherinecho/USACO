package March2014silver;
import java.util.*;
import java.io.*;
public class mooomoo {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("mooomoo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooomoo.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b =Integer.parseInt(st.nextToken());
		int[] breed = new int[b];
		Arrays.sort(breed);
		for(int i = 0; i < b; i++) {
			st = new StringTokenizer(in.readLine());
			breed[i] = Integer.parseInt(st.nextToken());
		}
		int[] input = new int[n];
		ArrayList<Integer> volume = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			 st = new StringTokenizer(in.readLine());
			 input[i] = Integer.parseInt(st.nextToken());
		}
		int prev = input[0];
		for(int i = 1; i < n; i++ ) {
			if(input[i] > prev) {
				if(prev > 0) {
					volume.add(input[i] - (prev -1));
				}else {
					volume.add(input[i]);
				}
			}
			prev = input[i];
		}
		Collections.sort(volume);
		System.out.println(volume);
		
		int[] memo = new int[volume.get(volume.size()-1) + 1];
		memo[0] = 0;
		for(int i = 1; i < breed[0]; i++) {
			memo[i] = -1;
		}
		for(int i = breed[0]; i < memo.length; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < breed.length; j++) {
				if(i - breed[j] >= 0) {
					if(memo[i - breed[j]] == -1) {
						memo[i] = -1;
					}else {
						min = Math.min(memo[i-breed[j]] + 1, min);
						memo[i] = min;
					}
				}
			}
			if(memo[i] != -1) {
				memo[i] = min;
			}
			System.out.println(memo[i]);
		}
	}
}
