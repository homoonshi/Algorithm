
import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int res[];
	static int num[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean isvisited[];
	static int start;
	static Set<String> have=new HashSet<>();
	static int temp;
	static char[] c;
	
	public static void main(String[] args) throws IOException{
		
		
		String input[]=br.readLine().split(" ");
		
		N=Integer.parseInt(input[0]);
		M=Integer.parseInt(input[1]);
		
		num=new int[N+1];
		
		input=br.readLine().split(" ");
		
		for(int i=1;i<=N;i++) {
			num[i]=Integer.parseInt(input[i-1]);
		}
		
		c=new char[M];
		Arrays.sort(num);
		res=new int[M];
		isvisited=new boolean[N+1];
		
//		start=1;
		permutation(0);
		
		
		bw.flush();
		
	}
	
	
	private static void permutation(int cnt) throws IOException {
		
		if(cnt==M) {
			
			String str= new String(c);
			
			
			if(have.contains(str)) {
				return;
			}
			
			for(int i=0;i<cnt;i++) {
				bw.write(res[i]+" ");
			}
			
			have.add(str);
			
			bw.write("\n");
			return;
		}
		
		
		for(int i=1;i<=N;i++) {
			
			if(cnt==0||(cnt==M-1&&isvisited[i-1]==false)) {
				if(num[i-1]==num[i]) {
					continue;
				}
			}
			
			if(cnt==0) {
				temp=0;
			}
			
			if(isvisited[i]==false) {
				res[cnt]=num[i];

				c[cnt]=(char) (num[i]+'0');

				isvisited[i]=true;
				permutation(cnt+1);
				isvisited[i]=false;
			}
		}
		
	}

}
