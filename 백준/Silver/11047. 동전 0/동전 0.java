
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] coins = new int[N];

        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        for(int i=N-1; i>=0; i--){
            if(K/coins[i]>0){
                result += K/coins[i];
                K%=coins[i];
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
