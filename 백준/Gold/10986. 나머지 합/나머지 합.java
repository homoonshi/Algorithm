
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        long sum[] = new long[N];
        long remain[] = new long[N];

        input = br.readLine().split(" ");
        long result = 0;

        long count[] = new long[M];
        long s = 0;

        for(int i=0; i<N; i++){
            s += Long.parseLong(input[i]);
            sum[i] = s;
            remain[i] = (long) sum[i] % M;
            count[(int)remain[i]]++;
        }

        for(int i=0; i<M; i++){
            result += (long) (count[i]*(count[i]-1))/2;
        }

        result += count[0];

        bw.write(result+"");
        bw.flush();

    }

}
