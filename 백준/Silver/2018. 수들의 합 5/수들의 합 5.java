import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] sum = new int[N+1];
        int temp = 0;

        for(int i=1; i<=N; i++){
            temp += i;
            sum[i] = temp;
        }

        int start = 0;
        int end = 1;

        int res = 0;

        while(start<end){

            if(end>N || start>N) break;

            int r = sum[end] - sum[start];

            if(r<N){
                end++;
            }else if(r>N){
                start++;
            }else{
                res++;
                start++;
            }

        }

        bw.write(res+"");
        bw.flush();

    }
}