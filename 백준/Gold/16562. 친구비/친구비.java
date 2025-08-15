import java.io.*;
import java.util.*;

public class Main {

    static class Friend implements Comparable<Friend> {
        int index;
        int cost;
        public Friend(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Friend o) {
            return this.cost-o.cost;
        }
    }

    static Friend[] friends;
    static int[] parents;
    static PriorityQueue<Friend> pq;
    static int N, M, k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        friends = new Friend[N+1];
        parents = new int[N+1];
        pq = new PriorityQueue<>();

        input = br.readLine().split(" ");

        for(int i=1; i<=N; i++){
            parents[i] = i;
            friends[i] = new Friend(i, Integer.parseInt(input[i-1]));
            pq.add(friends[i]);
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            union(v, w);
        }

        int res = 0;

        while(k>0 && !pq.isEmpty()){
            Friend f = pq.poll();
            if(searchParents(f.index)==0){
                continue;
            }
            if(k-f.cost<0){
                break;
            }
            union(0, f.index);
            k -= f.cost;
            res += f.cost;
        }

        for(int i=1; i<=N; i++){
            int p = searchParents(i);
            if(p!=0){
                bw.write("Oh no");
                bw.flush();
                return;
            }
        }

        bw.write(res+"");
        bw.flush();

    }

    public static int searchParents(int a){
        if(a==parents[a]){
            return a;
        }
        return parents[a] = searchParents(parents[a]);
    }

    public static void union(int a, int b){
        int parentA = searchParents(a);
        int parentB = searchParents(b);
        if(parentA==parentB){
            return;
        }
        if(parentA<parentB){
            parents[parentB] = parentA;
            searchParents(b);
        }else{
            parents[parentA] = parentB;
            searchParents(a);
        }
    }

}