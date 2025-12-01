import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] nums = new int[1000002];

        int res = 0;

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(input[i]);
            if(nums[n+1]==0){
                res++;
                nums[n]++;
            }else{
                nums[n+1]--;
                nums[n]++;
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}