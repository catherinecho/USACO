package Open2020silver;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class MyHashMap<K, V> extends HashMap<K, V> {

	Map<V, K> reverseMap = new HashMap<>();

	@Override
	public V put(K key, V value) {
		reverseMap.put(value, key);
		return super.put(key, value);
	}

	public K getKey(V value) {
		return reverseMap.get(value);
	}

}

// Program to get Map's key from value in Java
class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader("cereal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		MyHashMap<Integer, Integer> cereal = new MyHashMap();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int first = Integer.parseInt(st.nextToken());
			int sec = Integer.parseInt(st.nextToken());
			if(i ==0) {
				if(!cereal.containsKey(first)) {
					cereal.put(first, 1);
				}else {
					int c = cereal.get(first) +1;
					cereal.remove(first);
					cereal.put(first, c);
					
				}
			}
			else {
				if(!cereal.containsKey(first)) {
					cereal.put(first, 1);
				}else {
					int c = cereal.get(first) +1;
					cereal.remove(first);
					cereal.put(first, c);
				}
				if(!cereal.containsKey(sec)) {
					cereal.put(sec, 1);
				}
				else {
					int c = cereal.get(sec) +1;
					cereal.remove(sec);
					cereal.put(sec, c);
				}
			}
			
		}
		int[] ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(cereal.containsValue(0)) {
				System.out.println(cereal.getKey(0));
			}
		}
		
	}
}