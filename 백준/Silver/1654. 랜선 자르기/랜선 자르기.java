
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        long[] len = new long[K];
        long max = 0;

        for(int i=0; i<K; i++){
            len[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, len[i]);
        }

        long min = 0;
        max+=1;

        while(min<max){

            long mid = (min + max) / 2;
            long res = 0;

            for(int i=0; i<K; i++){
                res += (len[i]/mid);
            }

            if(res >= N){
                min = mid+1;
            }else{
                max = mid;
            }

        }

        bw.write((min-1)+"");
        bw.flush();

    }

}
