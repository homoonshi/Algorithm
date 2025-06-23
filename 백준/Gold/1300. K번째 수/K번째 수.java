
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;

        while(start<=end){

            long mid = (start + end) / 2;

            long cnt = 0;

            for(long i = 1; i <= N; i++){
                cnt += mid/i >= N ? N : mid/i;
            }

            if(cnt>=k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }

        bw.write(start+"");
        bw.flush();

    }
}