import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int N;
    static int[] graph;
    static int[] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = Integer.parseInt(br.readLine());
        }

        int m = 0;
        int res = 0;

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            int r = recursion(i);
            if(m < r){
                res = i;
                m = r;
            }
        }

        bw.write(res+"");
        bw.flush();

    }

    public static int recursion(int current){
        int next = graph[current];

        visited[current] = true;

        if(!visited[next]){
            return recursion(next) + 1;
        }

        return 1;
    }

}