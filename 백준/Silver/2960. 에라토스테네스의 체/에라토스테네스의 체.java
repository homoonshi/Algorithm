
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int count = 0;

        int[] visit = new int[N+1];

        for(int i = 2; i<=N; i++){

            if(visit[i]==1){
                continue;
            }

            visit[i] = 1;
            count++;

            if(count==K){
                bw.write(i+"");
                bw.flush();
                return;
            }

            for(int j=2; i*j<=N; j++){
                if(visit[i*j]==1){
                    continue;
                }
                visit[i*j] = 1;
                count++;
                if(count==K){
                    bw.write(i*j+"");
                    bw.flush();
                    return;
                }
            }

        }

    }

}
