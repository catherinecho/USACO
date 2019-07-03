package day6;
import java.util.*;
public class sigma {
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n =  in.nextInt();
        System.out.println(Sigma(n));
    }
    public static int Sigma(int n){
        if(n == 1){
            return 1;
        }
        return Sigma(n-1) + n;
    }
}
