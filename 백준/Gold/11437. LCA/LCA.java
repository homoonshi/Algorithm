
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] depth;
    static int[] parent;
    static Deque<Integer> graph[];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        depth = new int[N+1];
        parent = new int[N+1];

        graph = new Deque[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new ArrayDeque<>();
        }

        for(int i=0; i<N-1; i++){

            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].addLast(b);
            graph[b].addLast(a);

        }

        DFS();

        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){

            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int result = LCA(a, b);

            bw.write(result+"\n");

        }

        bw.flush();

    }

    public static int LCA(int a, int b){

        if(a==b){
            return a;
        }

        if(depth[a]<depth[b]){
            return LCA(a,parent[b]);
        }else if(depth[a]>depth[b]){
            return LCA(parent[a], b);
        }else {
            return LCA(parent[a], parent[b]);
        }

    }

    public static void DFS(){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);

        depth[1] = 1;

        while(!deque.isEmpty()){

            int n = deque.pollLast();
            int length = graph[n].size();

            for(int i=0; i<length; i++){

                int next = graph[n].pollFirst();
                deque.addLast(next);

                if(depth[next]==0) {
                    depth[next] = depth[n] + 1;
                    parent[next] = n;
                }

            }

        }

    }
}
