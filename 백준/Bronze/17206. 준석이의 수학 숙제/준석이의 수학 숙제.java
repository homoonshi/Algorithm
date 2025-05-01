
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] dp = new int[80001];
        int sum = 0;

        for(int i=1; i<=80000; i++){
            if(i%3==0||i%7==0){
                sum += i;
            }

            dp[i] = sum;
        }

        for(int i=0; i<T; i++){

            int n = Integer.parseInt(input[i]);
            bw.write(dp[n]+"\n");

        }

        bw.flush();

    }
}