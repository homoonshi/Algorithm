
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        long[] remain = new long[N];

        for(int i=0; i<N; i++){
            remain[i] = (long) Math.abs(Integer.parseInt(input[i]) - S);
        }

        long D = remain[0];

        for(int i=1; i<N; i++){
            D = Math.min(D, gcd(D, remain[i]));
        }

        if(N==1){
            D = remain[0];
        }

        bw.write(D+"");
        bw.flush();

    }

    public static long gcd(long a, long b){
        if(a%b == 0){
            return b;
        }
        return gcd(b, a%b);
    }

}
