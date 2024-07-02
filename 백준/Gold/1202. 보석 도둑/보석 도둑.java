
import java.io.*;
import java.util.*;

public class Main {

    static class Gem implements Comparable<Gem>{

        int M;
        int V;

        public Gem(int M, int V){
            this.M = M;
            this.V = V;
        }


        @Override
        public int compareTo(Gem o) {
            return o.V-this.V;
        }
    }

    static int N, K;
    static int[] C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int[][] gem = new int[N][2];
        C = new int[K];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            gem[i][0] = Integer.parseInt(input[0]);
            gem[i][1] = Integer.parseInt(input[1]);
        }

        for(int i=0; i<K; i++){
            C[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Gem> pq = new PriorityQueue<>();

        Arrays.sort(C);
        Arrays.sort(gem,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);

        int currentGem = 0;
        long res = 0;

        for(int i=0; i<K; i++){
            for(; currentGem<N; currentGem++){
                if(C[i]<gem[currentGem][0]){
                    break;
                }
                pq.add(new Gem(gem[currentGem][0],gem[currentGem][1]));
            }
            if(!pq.isEmpty()) {
                res += pq.poll().V;
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}