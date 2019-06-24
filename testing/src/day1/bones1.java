package day1;
import java.util.*;
import java.io.*;

public class bones1 {

   static Scanner in = new Scanner (System.in);
   static int a;
   static int max;
   static int d1 = in.nextInt();
   static int d2 = in.nextInt();
   static int d3 = in.nextInt();
   public static void main(String[] args) {
	   try {
			init();
			
			System. out.print(solve());
		}catch(Exception e){
			e.printStackTrace();
		}
   }
   public static void init() {
	   a = 0;
	   max = 0;
	   d1 = in.nextInt();
       d2 = in.nextInt();
       d3 = in.nextInt();
	   
   }
   public static int solve() {
	   int [] f = new int [1001];

       for(int i=1;i<=d3;i++){
            for(int j=1;j<=d2;j++){
               for(int k=1;k<=d1;k++){
                   f[i+j+k]++;
               }
           }
       }
       for(int i=1;i<=d1+d2+d3;i++){
           if(max<f[i]){
               a=i;
               max=f[i];
           }
       }
       return a;
   }
}