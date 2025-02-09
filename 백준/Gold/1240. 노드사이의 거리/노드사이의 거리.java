
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<int[]>[] map;

    static int[] parent;
    static int[] depth;
    static int[] dist;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new List[N+1];

        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);

            map[a].add(new int[]{b, d});
            map[b].add(new int[]{a, d});

        }

        parent = new int[N+1];
        depth = new int[N+1];
        dist = new int[N+1];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);

        while(!deque.isEmpty()){
            int index = deque.pollFirst();
            for(int i=0; i<map[index].size(); i++){
                int[] child = map[index].get(i);

                if(parent[index]==child[0] || parent[child[0]]!=0){
                    continue;
                }

                parent[child[0]] = index;
                depth[child[0]] = depth[index] + 1;
                dist[child[0]] = child[1] + dist[index];

                deque.add(child[0]);
            }
        }

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int distance = searchDistance(a, b);

            bw.write(distance+"\n");
        }


        bw.flush();

    }

    public static int searchDistance(int a, int b){

        int aDepth = depth[a];
        int bDepth = depth[b];

        int aIndex = a;
        int bIndex = b;

        while(bDepth>aDepth){
            bIndex = parent[bIndex];
            bDepth--;
        }

        while(aDepth>bDepth){
            aIndex = parent[aIndex];
            aDepth--;
        }

        while(aIndex != bIndex){
            aIndex = parent[aIndex];
            bIndex = parent[bIndex];
        }

        return dist[a] + dist[b] - 2 * dist[aIndex];
    }

}
