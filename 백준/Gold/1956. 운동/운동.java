import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Route implements Comparable<Route> {
        int next;
        int dis;

        public Route(int next, int dis) {
            this.next = next;
            this.dis = dis;
        }

        @Override
        public int compareTo(Route o) {
            return this.dis-o.dis;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        int res = Integer.MAX_VALUE;
        int[][] map = new int[V+1][V+1];

        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int dis = Integer.parseInt(input[2]);
            map[start][end] = dis;
        }

        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(map[i][j]==0) continue;
                for(int k=1; k<=V; k++){
                    if(map[j][k]==0) continue;
                    int d = map[i][j] + map[j][k];
                    if(map[i][k]==0 || map[i][k]>d){
                        map[i][k] = d;
                    }
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(map[i][i]!=0) {
                res = Math.min(res, map[i][i]);
            }
        }

        if(res!=Integer.MAX_VALUE) {
            bw.write(res + "");
        }else{
            bw.write("-1");
        }
        bw.flush();

    }
}