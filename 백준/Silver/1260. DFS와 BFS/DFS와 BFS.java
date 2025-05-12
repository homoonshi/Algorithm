
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static boolean[][] map;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        map = new boolean[N+1][N+1];

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            map[a][b] = true;
            map[b][a] = true;
        }

        boolean[] dfs = DFS(new boolean[N+1], V);
        bw.write("\n");
        BFS();

        bw.flush();
    }

    public static void BFS() throws IOException {

        boolean[] visited = new boolean[N+1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(V);
        visited[V] = true;

        while(!deque.isEmpty()){

            int start = deque.pollFirst();
            bw.write(start+" ");

            for(int end=1; end<=N; end++){

                if(map[start][end] && !visited[end]){
                    deque.addLast(end);
                    visited[end] = true;
                }

            }

        }

    }

    public static boolean[] DFS(boolean[] visited, int start) throws IOException {

        bw.write(start+" ");
        visited[start] = true;

        for(int end=1; end<=N; end++){
            if(map[start][end] && !visited[end]){
                visited = DFS(visited, end);
            }
        }

        return visited;
    }

}