package exam1;
import java.util.*;

public class elect {
	static Scanner in = new Scanner (System.in);
    static ArrayList<vt> votes=  new ArrayList<vt>();
    static int N = in.nextInt();
    static int K = in.nextInt();
    static int [] finals = new int [K];
    static int [] finalsIndex = new int [K];
    static HashMap<Integer, Integer>  index = new LinkedHashMap<Integer,Integer>();
    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            int pre = in.nextInt();
            int fin = in.nextInt();
            votes.add(new vt(pre, fin));
            index.put(fin, i);
        }
        
        Collections.sort(votes);
       
        for(int i = 0; i < K; i++) {
        		finals[i] = votes.get(i).fin;
        }
        int max = 0;
        for(int i = 0; i < K;i++) {
        		if(finals[i] > max) {
        			max = finals[i];
        		}
        }
        System.out.println(index.get(max) + 1);
       
    }
}
class vt implements Comparable<vt>{
	int pre;
	int fin; 
	public int compareTo(vt m) {
		if(this.pre - m.pre != 0) {
			return m.pre - this.pre;
		}else {
			return -1;
		}
		
	}
	public vt(int p, int f) {
		this.pre = p; 
		 this.fin = f;
	}
	public int getP() {return pre;}
	public int getF() {return fin;}
}
