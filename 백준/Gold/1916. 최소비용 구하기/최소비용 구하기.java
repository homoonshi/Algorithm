
import java.io.*;
import java.util.*;

public class Main {

    static class Bus implements Comparable<Bus> {

        int index;
        int distance;

        public Bus(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Bus o) {
            return this.distance - o.distance;
        }
    }

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(map[i], 1000000001);
        }

        String[] input;

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            map[start][end] = Math.min(map[start][end], cost);

        }

        input = br.readLine().split(" ");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        if(start==end){
            bw.write("0");
            bw.flush();
            return;
        }

        PriorityQueue<Bus> pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++) {
            if(start==i) continue;
            pq.add(new Bus(i, map[start][i]));
        }

        while(!pq.isEmpty()){
            Bus temp = pq.poll();
            for(int i=1; i<=N; i++){
                if(temp.index==i) continue;
                int distance = temp.distance + map[temp.index][i];
                if(map[start][i] > distance){
                    map[start][i] = distance;
                    pq.add(new Bus(i, distance));
                }
            }
        }

        bw.write(map[start][end]+"");
        bw.flush();

    }
}