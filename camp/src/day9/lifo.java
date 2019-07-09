package day9;
import java.util.*;
public class lifo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		Stack <Character> s = new Stack<Character>();
		boolean b = true;
		for(int i = 0;i <a.length(); i++ ) {
			if(a.charAt(i) == '(' || a.charAt(i) == '[' ||a.charAt(i) == '{') {
				s.push(a.charAt(i));
			}else {
				if(s.isEmpty()) {
					System.out.println("Not valid");
					b = false;
					break;
				}
				if(a.charAt(i) == ')' && s.peek()!= '(') {
					System.out.println("Not valid");
					b = false;
					break;
				}
				if(a.charAt(i) == ']' && s.peek()!= '[') {
					System.out.println("Not valid");
					b = false;
					break;
				}
				if(a.charAt(i) == '}' && s.peek()!= '{') {
					System.out.println("Not valid");
					b = false;
					break;
				}
				s.pop();
			}
		}
		if(b == true) {
			System.out.println("Valid");
		}
		
	}
}
