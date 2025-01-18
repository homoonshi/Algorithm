
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        long M = Integer.parseInt(input[0]);
        long N = Integer.parseInt(input[1]);

        boolean[] visit = new boolean[(int) (N+1)];

        for(int i=2; i<=N; i++){

            if(visit[i]){
                continue;
            }

            if(i>=M){
                bw.write(i+"\n");
            }

            if((long)i*i <= N) {
                for (long j = i * i; j <= N; j += i) {
                    visit[(int) j] = true;
                }
            }

        }

        bw.flush();

    }

}
