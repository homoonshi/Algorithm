
import java.io.*;
import java.util.*;

public class Main {

    static class Sequence implements Comparable<Sequence> {
        int index;
        int num;

        public Sequence(int index, int num) {
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(Sequence o) {
            return this.num==o.num ? this.index-o.index : this.num-o.num;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Sequence[] sequences = new Sequence[N+1];
        PriorityQueue<Sequence> pq = new PriorityQueue<>();

        String[] input = br.readLine().split(" ");

        for(int i=1; i<=N; i++){

            int num = Integer.parseInt(input[i-1]);

            Sequence sequence = new Sequence(i, num);

            sequences[i] = sequence;
            pq.add(sequence);

        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            if(input[0].equals("2")){
                bw.write(pq.peek().index+"\n");
                continue;
            }

            int index = Integer.parseInt(input[1]);
            int num = Integer.parseInt(input[2]);

            sequences[index].num = num;
            pq.remove(sequences[index]);
            pq.add(sequences[index]);
        }

        bw.flush();

    }

}
