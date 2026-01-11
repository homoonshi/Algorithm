import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int D = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] count = new int[D+1][2];
        count[1][0] = 1;
        if(D>=2) {
            count[2][1] = 1;
        }

        for(int i=3; i<=D; i++){
             count[i][0] = count[i-1][0] + count[i-2][0];
             count[i][1] = count[i-1][1] + count[i-2][1];
        }

        long a = 0;
        long b = 0;

        loof : for(int i=1; i<=100000; i++){
            a = count[D][1] * i;
            if(a + count[D][0]*i < K) continue;
            int start = (int)((K - a)/count[D][0]);
            for(int j=start; j<=i; j++){
                b = count[D][0]*j;
                if(K == a + b){
                    break loof;
                }
            }
        }

        bw.write(b/count[D][0]+"\n");
        bw.write(a/count[D][1]+"");

        bw.flush();

    }
}