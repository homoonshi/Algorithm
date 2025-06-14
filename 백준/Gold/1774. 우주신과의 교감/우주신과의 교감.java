
import java.io.*;
import java.util.*;

public class Main {

    static class Route implements Comparable<Route> {
        int a;
        int b;
        double distance;

        public Route(int a, int b, double distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Route o) {
            return Double.compare(this.distance, o.distance);
        }
    }

    static int N, M;
    static int[][] map;
    static int[] parent;
    static PriorityQueue<Route> pq;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        pq = new PriorityQueue<>();

        map = new int[N+1][2];
        parent = new int[N+1];

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(input[0]);
            map[i][1] = Integer.parseInt(input[1]);
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            group(a, b);
        }

        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                if(search(i) != search(j)){
                    double d = Math.pow(Math.abs(map[i][0] - map[j][0]), 2)
                            + Math.pow(Math.abs(map[i][1] - map[j][1]), 2);
                    pq.add(new Route(i, j, d));
                }
            }
        }

        double res = 0;

        while(!pq.isEmpty()){
            Route route = pq.poll();
            if(!group(route.a, route.b)){
                res += Math.sqrt(route.distance);
            }
        }

        System.out.printf("%.2f\n", res);

    }

    public static boolean group(int a, int b){
        int aParent = search(a);
        int bParent = search(b);

        if(aParent == bParent) return true;

        if(aParent < bParent) {
            parent[bParent] = aParent;
        }else{
            parent[aParent] = bParent;
        }

        return false;
    }

    public static int search(int index){
        if(parent[index] == index){
            return index;
        }
        return parent[index] = search(parent[index]);
    }

}