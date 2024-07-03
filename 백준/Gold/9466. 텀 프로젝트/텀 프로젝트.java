import java.io.*;
import java.util.*;

public class Main {

    static int[] S;
    static int T;
    static int N;
    static int res;
    static int[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;

        T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            N = Integer.parseInt(br.readLine());
            S = new int[N+1];
            res = 0;

            input = br.readLine().split(" ");

            for(int i=1; i<=N; i++){
                S[i] = Integer.parseInt(input[i-1]);
            }

            int temp;

            visit = new int[N+1];

            for(int i=1; i<=N; i++){
                DFS(i,i);
            }

            bw.write(res+"\n");

        }

        bw.flush();

    }


    public static void DFS(int n, int start){

        if(visit[n]==0){
            visit[n]=1;
            DFS(S[n],start);
        }else{

            if(start==n) return;

            for(int i=start; i!=n; i=S[i]){
                res++;
            }

        }

    }

}