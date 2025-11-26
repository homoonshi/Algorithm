import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long r = 0;

        int[][] t = new int[n][2];

        for(int test_case = 0; test_case < n; test_case++) {
            int L = Integer.parseInt(br.readLine());

            int[] nums = new int[L];
            String[] input = br.readLine().split(" ");
            long res = -1000000;

            for(int i=0; i<L; i++){
                nums[i] = Integer.parseInt(input[i]);
                if(res < nums[i]){
                    res = nums[i];
                    t[test_case][0] = i;
                    t[test_case][1] = i;
                }
            }

            int start = 0;
            int end = 0;
            long sum = 0;

            while(end < L){
                sum += nums[end];
                if(res > sum && sum <= 0){
                    end++;
                    start = end;
                    sum = 0;
                    continue;
                }
                if(res <= sum){
                    if(res < sum || t[test_case][1] - t[test_case][0] > end - start) {
                        t[test_case][0] = start;
                        t[test_case][1] = end;
                    }
                    res = sum;
                }
                end++;
            }

            r += res;

        }

        bw.write(r+"\n");
        for(int i=0; i<n; i++){
            bw.write((t[i][0]+1)+" "+(t[i][1]+1)+"\n");
        }
        bw.flush();


    }
}