
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] nums = new int[N];
        int sum = 0;
        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            sum += Integer.parseInt(input[i]);
            nums[i] = sum;
        }

        int res = nums[K-1];

        for(int i=K; i<N; i++){
            res = Math.max(res, nums[i] - nums[i-K]);
        }

        bw.write(res+"");
        bw.flush();

    }
}