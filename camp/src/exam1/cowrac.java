package exam1;
import java.io.*;
import java.util.*;
public class cowrac{

    public static void main(String[] args) throws IOException {
            Scanner in = new Scanner (System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[] elise;
            int[] bessie;
            int [] bessieT = new int [n];
            int [] bessieS = new int [n];
            int [] eliseT = new int [m];
            int [] eliseS = new int [m];
            int time1 = 0;
            int time2 = 0;
            for (int i = 0; i < n; i++){
            		bessieS[i] = in.nextInt();
                bessieT[i] = in.nextInt();
                time1 = time1 + bessieT[i];
            }
            for (int i = 0; i < m; i++){
                eliseS[i] = in.nextInt();
                eliseT[i] = in.nextInt();
                time2 = time2 + eliseT[i];
            }
            bessie = new int [time1];
            elise = new int [time2];
            int temp = 0;
            for (int i = 0; i < n; i++){
                int speed = bessieS[i];
                int time = bessieT[i];
                for (int a = temp; a < time + temp; a++) {
                    bessie [a] = speed;
                }
                temp += time;
            }
            temp = 0;
            for (int i = 0; i < m; i++){
                int speed = eliseS[i];
                int time = eliseT[i];
                for (int a = temp; a < time + temp; a++) {
                    elise [a] = speed;
                }
                temp += time;
            }
            //System.out.println(Arrays.toString(bessie));
            int change = 0;
            for (int i = 1; i < time1; i++) {
                if (bessie [i] > elise [i]) {
                    if (bessie [i] != bessie [i-1] && bessie[i] * i != elise[i] * i) change++;
                    System.out.println(i);
                }
                
                else if (bessie [i] < elise [i]) {
                    if (elise [i] != elise [i-1]) change++;
                }
            }
            System.out.println(change-1);
    }
}
