
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];

        int[] L = new int[N];
        int[] R = new int[N];

        String[] input = br.readLine().split(" ");
        
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        
        L[0] = nums[0];
        int res = L[0];
        
        for(int i=1; i<N; i++){
            L[i] = Math.max(nums[i], L[i-1]+nums[i]);
            res = Math.max(res, L[i]);
        }
        
        R[N-1] = nums[N-1]; 

        for(int i=N-2; i>=0; i--){
            R[i] = Math.max(nums[i], R[i+1]+nums[i]);
        }

        for(int i=1; i<N-1; i++){
            res = Math.max(res, L[i-1]+R[i+1]);
        }

        bw.write(res+"");
        bw.flush();

    }

}
