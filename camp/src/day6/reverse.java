package day6;

import java.util.*;
public class reverse{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String word = in.next();
        int change = 0;
        r(word.length()-1, word);
        
    }
    public static void r(int change, String word){
    		System.out.print(word.charAt(change));
        if(change > 0){
        		change--;
           r(change, word);
           
        }
        
        
    }
}