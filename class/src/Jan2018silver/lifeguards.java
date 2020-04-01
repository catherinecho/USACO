package Jan2018silver;
import java.util.*;
import java.io.*;
public class lifeguards {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		cow[] times = new cow[n*2];
		for(int i = 0; i < n* 2; i+= 2){
			times[i]= new cow(in.nextInt(), i/2);
			times[i+1] =new cow(in.nextInt(), i/2);
		}
		TreeSet<Integer> overlap = new TreeSet<Integer>();
		int[] solo = new int[n];
		int total = 0;
		int previous = 0;
		Arrays.sort(times);
		for(int i = 0; i < times.length; i++){
			
			if(overlap.size() ==1){
				solo[overlap.first()] = times[i].time- previous ;
			}
			if(overlap.size()>0){
				total += times[i].time - previous;
			}
			if(!overlap.contains(times[i].id)){
				overlap.add(times[i].id);
			}else{
				overlap.remove(times[i].id);
			}
			previous = times[i].time;
		}
		int min = Integer.MAX_VALUE;
		for(int i =0 ; i < n; i++){
			min = Math.min(solo[i], min);
		}
		total -= min;
		System.out.println(total);
	}

}
class cow implements Comparable<cow>{
	int time;
	int id; 
	public int compareTo(cow m){
		return this.time - m.time;
	}
	public cow (int t, int i){
		this.time = t;
		this.id = i;
	}
}
