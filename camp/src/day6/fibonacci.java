package day6;
import java.util.*;
public class fibonacci {
	public static void main(String[] args) {
		System.out.println(8);
	}
	public int Fib(int n) {
		  if(n == 0)
		    return 0;
		  if(n == 1){
		    return 1;
		  }
		  return Fib(n-1) + Fib(n-2);
		}

}
