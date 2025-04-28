
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        long M = Long.parseLong(input[1]);

        long[] tree = new long[N];
        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            tree[i] = Long.parseLong(input[i]);
        }

        long start = 0;
        long end = 1000000000;

        long m = 0;

        while(start<end){

            long mid = (start+end) / 2;
            m = 0;

            for(int i=0; i<N; i++){
                if(tree[i]>mid){
                    m += tree[i] - mid;
                }
            }

            if (m<M){
                end = mid-1;
            }else{
                start = mid+1;
            }

        }


        while(true){

            m = 0;

            for(int i=0; i<N; i++){
                if(tree[i]>start){
                    m += tree[i] - start;
                }
            }

            if(m>=M){
                break;
            }

            start--;

        }

        bw.write(start+"");
        bw.flush();

    }
}