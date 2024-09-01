import java.io.*;
import java.util.*;

public class Main {

    static class Route implements Comparable<Route>{

        int start, end, weight;

        public Route(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Route o) {
            return this.weight - o.weight;
        }

    }

    static int n, m;
    static int[][] distance;
    static int[][] result;
    static List<Route>[] routes;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        distance = new int[n+1][n+1];
        result = new int[n+1][n+1];
        routes = new List[n+1];

        for(int i=1; i<=n; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
            routes[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            routes[a].add(new Route(a,b,w));
            routes[b].add(new Route(b,a,w));

        }

        for(int i=1; i<=n; i++) {
            getShortRoute(i);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){

                if(i==j){
                    bw.write("- ");
                    continue;
                }

                bw.write(result[i][j]+" ");

            }
            bw.write("\n");
        }

        bw.flush();
    }

    public static void getShortRoute(int start){

        PriorityQueue<Route> pq = new PriorityQueue<>();
        pq.add(new Route(start,start,0));

        while(!pq.isEmpty()){

            Route temp = pq.poll();

            int s = temp.start;
            int e = temp.end;

            for(Route r : routes[e]){

                if(start==r.end || s==r.end){
                    continue;
                }

                if(distance[start][r.end] > distance[start][e]+r.weight){
                    distance[start][r.end] = distance[start][e]+r.weight;

                    if(start==r.start){
                        result[start][r.end] = r.end;
                    }else {
                        result[start][r.end] = result[start][e];
                    }

                    pq.add(r);

                }

            }


        }

    }

}