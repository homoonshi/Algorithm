
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] res = new int[2];
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = N-1;

        Arrays.sort(nums);

        while(start<end){

            int distance = Math.abs(nums[start]+nums[end]);

            if(distance<min){
                min = distance;
                res[0] = nums[start];
                res[1] = nums[end];
            }

            int disL = Math.abs(nums[start+1]+nums[end]);
            int disR = Math.abs(nums[start]+nums[end-1]);

            if(disL<disR){
                start++;
            }else{
                end--;
            }

        }

        bw.write(res[0]+" "+res[1]);
        bw.flush();

    }
}