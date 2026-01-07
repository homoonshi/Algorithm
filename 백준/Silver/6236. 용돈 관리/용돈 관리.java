import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);


        long[] nums = new long[N+1];
        long start = 0;
        long end = 0;

        for(int i=1; i<=N; i++){
            end += Integer.parseInt(br.readLine());
            nums[i] = end;
            start = Math.max(start, nums[i] - nums[i-1]);
        }

        long res = 0;

        loof : while(start <= end){
            long mid = (start+end) / 2;
            int count = 1;
            int left = 0;

            for(int i=1; i<=N; i++){
                if(nums[i] - nums[left] > mid){
                    left = i-1;
                    count++;
                }

                if(count > M){
                    start = mid + 1;
                    continue loof;
                }
            }

            if(count <= M){
                res = mid;
                end = mid - 1;
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}