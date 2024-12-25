
import java.util.*;
import java.io.*;

public class Main {

    static class Pair implements Comparable<Pair>{

        int i;
        int j;
        int value;

        public Pair(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return o.value - this.value;
        }
    }

    static int N;
    static int[] present;
    static int[][] value;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        present = new int[4];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(input[i]);
            present[num]++;
        }

        calValue();

        int result = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<4; i++){
            for(int j=i; j<4; j++){
                if(present[i] > 0 && present[j] > 0){
                    pq.add(new Pair(i, j, value[i][j]));
                }
            }
        }

        while(!pq.isEmpty()){

            Pair temp = pq.poll();

            int minCount = Math.min(present[temp.i], present[temp.j]);

            if(minCount < 0){
                continue;
            }

            result += minCount * temp.value;

            present[temp.i] -= minCount;
            present[temp.j] -= minCount;

        }

        bw.write(result+"");
        bw.flush();

    }

    public static void calValue(){
        value = new int[4][4];
        for(int i=0; i<=3; i++){
            for(int j=0; j<=3; j++){
                value[i][j] = i ^ j;
            }
        }
    }

}
