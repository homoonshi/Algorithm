
import java.io.*;
import java.util.*;

public class Main {

    static boolean find;
    static List<Integer>[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        map = new List[N];

        for(int i=0; i<N; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            map[a].add(b);
            map[b].add(a);
        }

        find = false;

        for(int i=0; i<N; i++){
            visited = new boolean[N];
            DFS(i, 1);
        }

        bw.write(find ? "1" : "0");
        bw.flush();

    }

    public static void DFS(int index, int depth){
        if(depth==5||find){
            find=true;
            return;
        }
        visited[index] = true;
        for (Integer i : map[index]) {
            if(!visited[i]){
                DFS(i, depth+1);
            }
        }
        visited[index] = false;
        return;
    }

}
