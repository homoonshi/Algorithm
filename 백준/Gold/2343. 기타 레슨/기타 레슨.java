import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        long start = 0;
        long end = 0;

        input = br.readLine().split(" ");

        long[] nums = new long[N+1];

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(input[i]);
            start = Math.max(start, n);
            end += n;
            nums[i+1] = end;
        }

        while(start<=end){

            long mid = (start+end) / 2 ;

            int count = 0;
            int left = 0;

            for(int i=1; i<=N; i++){
                long len = nums[i] - nums[left];
                if(len>=mid){
                    left = len==mid ? i : i-1;
                    count++;
                }
            }

            if(left!=N){
                count++;
            }

            if(count>M){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }

        bw.write(start+"");
        bw.flush();

    }
}