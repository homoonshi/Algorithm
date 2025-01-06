import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> parent;
    static int max;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new ArrayList<>();
        visited = new boolean[N+1];
        count = new int[N+1];
        max = 0;

        for(int i=0; i<=N; i++){
            parent.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            parent.get(A).add(B);
        }

        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            dfs(i);
        }

        for(int i=1; i<=N; i++){
            if(max==count[i]){
                bw.write(i+" ");
            }
        }

        bw.flush();

    }

    public static void dfs(int child){
        visited[child] = true;

        for (Integer p : parent.get(child)) {
            if(visited[p]){
                continue;
            }
            count[p]++;
            max = Math.max(max, count[p]);
            dfs(p);
        }

    }

}
