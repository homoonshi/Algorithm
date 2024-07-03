import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] early;
    static Deque<Integer>[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;

        N = Integer.parseInt(br.readLine());
        early = new int[N+1];
        tree = new ArrayDeque[N+1];

        for(int i=1; i<=N; i++){
            tree[i] = new ArrayDeque<>();
        }

        for(int i=1; i<N; i++){
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            tree[u].add(v);
            tree[v].add(u);

        }

        DFS(1, 1);

        int res = 0;

        for(int i=1; i<=N; i++){
            if(early[i]==1) res++;
        }

        bw.write(res+"");
        bw.flush();

    }

    static public void DFS(int start, int before) {

        int count = 0;
        int length = tree[start].size();

        for (int i = 0; i < length; i++) {

            if(!tree[start].isEmpty()) {

                int next = tree[start].pollFirst();

                if (early[next] == 0 && next != before) {
                    DFS(next,start);
                }

                if (early[next] == 1) {
                    count++;
                }

            }

        }

        if (start!=before && count != length-1 ) {
            early[start] = 1;
        }

        if( start==before && count != length ){
            early[start] = 1;
        }
    }


}