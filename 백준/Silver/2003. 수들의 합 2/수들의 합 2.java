
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] A = new int[N];
        input = br.readLine().split(" ");

        int sum = 0;
        int res = 0;

        for(int i=0; i<N; i++){
            sum += Integer.parseInt(input[i]);
            A[i] = sum;
            if(A[i]==M){
                res++;
            }
        }

        int start = 0;
        int end = 1;

        while(end<N){

            int mid = A[end] - A[start];

            if(mid==M){
                res++;
                end++;
                start++;
            }else if(mid<M){
                end++;
            }else if(mid>M){
                start++;
            }

        }

        bw.write(res+"");
        bw.flush();

    }
}