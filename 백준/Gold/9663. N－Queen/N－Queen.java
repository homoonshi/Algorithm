
import java.util.*;
import java.io.*;

public class Main {
	
	static int num=0;
	static int N;
	static int until[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		num=0;
		until=new int[N][2];
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		for(int i=0;i<N;i++) {
			recursion(i,0,0);
		}
		
		System.out.print(num);
	}
	
	static int go[][]= {{0,1},{1,1},{-1,1}};
	
	private static void recursion(int i,int j,int count) {
		
		if(j==0) {
			until[count][0]=i;
			until[count][1]=j;
			for(int m=0;m<N;m++) {
				recursion(m,j+1,count+1);
			}
			return;
		}
		
		int tx,ty;
		int dis;
		
		for(int m=0;m<count;m++) {
			
			dis=j-m;
			
			for(int n=0;n<3;n++) {
				
				tx=until[m][0]+go[n][0]*dis;
				ty=until[m][1]+go[n][1]*dis;
				
				if(tx==i&&ty==j) {
					return;
				}
				
			}
			
			
		}
		
		if(j==N-1) {
			num=num+1;
			return;
		}
		
		
		until[count][0]=i;
		until[count][1]=j;
		
		for(int m=0;m<N;m++) {
			recursion(m,j+1,count+1);
		}
		
		
	}

}
