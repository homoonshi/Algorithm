import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);

        boolean[] red = new boolean[N+1];

        for(int i=0; i<B; i++){
            int index = Integer.parseInt(br.readLine());
            red[index] = true;
        }

        int res = 0;

        for(int i=1; i<=K; i++){
            if(red[i]){
                res++;
            }
        }

        int start = 1;
        int end = K+1;

        int current = res;

        for(;end<=N; end++){
            if(red[start++]){
                current--;
            }
            if(red[end]){
                current++;
            }
            res = Math.min(res, current);
        }

        bw.write(res+"");
        bw.flush();

    }
}