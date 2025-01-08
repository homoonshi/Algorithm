
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] T;
    static int[] P;
    static int result;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];

        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split(" ");

            int day = Integer.parseInt(input[0]);
            int cost = Integer.parseInt(input[1]);

            if(day + i-1 > N){
                continue;
            }

            T[i] = day;
            P[i] = cost;

        }

        result = 0;

        count(1, 0);

        bw.write(result+"");
        bw.flush();

    }

    public static void count(int d, int c){

        if(d==N+1){
            result = Math.max(result, c);
            return;
        }

        if(T[d]==0){
            count(d+1, c);
            return;
        }

        count(d+T[d], c + P[d]);

        count(d+1, c);

    }

}
