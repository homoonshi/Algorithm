import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] dp;
    static int[] ddp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        dp = new int[N][N+1];
        ddp = new int[N];

        for(int i=0; i<N; i++){
            int min = nums[i];
            int max = nums[i];
            dp[i][1] = 0;
            for(int j=i+1; j<N; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                dp[i][j-i+1] = max - min;
            }
        }

        for(int i=N-1; i>=0; i--) {
            memo(i);
        }

        bw.write(ddp[0]+"");
        bw.flush();

    }

    public static void memo(int index){

        for(int i=1; i<=N-index; i++){
            ddp[index] = Math.max(ddp[index], dp[index][i] + (index+i >= N ? 0 : ddp[index+i]));
        }
    }

}