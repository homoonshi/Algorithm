import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        long[] a = new long[n];
        long[] sub = new long[n];

        for(int i=0; i<n; i++){
            a[i] = Long.parseLong(input[i]);
        }

        input = br.readLine().split(" ");

        for(int j=0; j<n; j++){
            sub[j] = a[j] - Long.parseLong(input[j]);
        }

        long res = sub[0];

        for(int i=1; i<n; i++){
            res = gcd(res, sub[i]);
        }

        bw.write(res+"");
        bw.flush();

    }

    public static long gcd(long x, long y){
        return (y == 0) ? x : gcd(y, x % y);
    }

}
