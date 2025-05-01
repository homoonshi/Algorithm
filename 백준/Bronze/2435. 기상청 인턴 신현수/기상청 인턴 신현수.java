
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] sum = new int[N];
        input = br.readLine().split(" ");
        int s = 0;

        for(int i=0; i<N; i++){
            s += Integer.parseInt(input[i]);
            sum[i] = s;
        }

        int res = sum[K-1];

        for(int i=K; i<N; i++){
            res = Math.max(res, sum[i] - sum[i-K]);
        }

        bw.write(res+"");
        bw.flush();

    }
}