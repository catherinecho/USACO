package Jan2017silver;
import java.util.*;
import java.io.*;
public class cowcode {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("cowcode.in"));
		PrintWriter out = new PrintWriter(new File("cowcode.out"));
		String word = in.next();
		long index = in.nextLong();
		word += word.charAt(word.length()-1);
		while(index > word.length()) {
			long x = word.length()-1; 
			while(x < index) {
				x = x * 2;
			}
			x = x / 2;
			if(x + 1 == index) {
				index = x; 
				x = x / 2;
			}
			index = index - x - 1;
		}
		out.println(word.charAt((int)index -1));
		in.close();
		out.close();
	}
}
