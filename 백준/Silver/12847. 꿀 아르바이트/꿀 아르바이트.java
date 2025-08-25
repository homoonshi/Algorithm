import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        long[] cost = new long[n+1];
        long sum = 0;

        for(int i=0; i<n; i++){
            sum += Integer.parseInt(input[i]);
            cost[i+1] = sum;
        }

        long res = 0;

        for(int start = m; start<=n; start++){
            res = Math.max(res, cost[start]-cost[start-m]);
        }

        bw.write(res+"");
        bw.flush();

    }
}