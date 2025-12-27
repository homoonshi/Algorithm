import java.io.*;
import java.util.*;

public class Main {

    static long[][] nums;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        nums = new long[2][N+1];
        nums[0][N-1] = 1;
        nums[1][N] = 1;

        for(int i=N-1; i>0; i--){
            nums[0][i] += nums[0][i+1];
            nums[1][i] += nums[1][i+1];
            if(i+2 <= N){
                nums[0][i] += nums[1][i+2];
                nums[1][i] += nums[0][i+2];
            }
            nums[0][i] %= 15746;
            nums[1][i] %= 15746;
        }

        long res = (nums[0][1] + nums[1][1]) % 15746;

        bw.write(res+"");
        bw.flush();
    }


}