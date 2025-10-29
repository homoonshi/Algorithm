import java.io.*;
import java.util.*;

public class Main {

    static class Work implements Comparable<Work> {
        int p;
        int s;

        Work(int p, int s){
            this.p = p;
            this.s = s;
        }

        @Override
        public int compareTo(Work o) {
            return o.s - this.s;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input;

        Work[] works = new Work[N];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            int t = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);

            works[i] = new Work(t, s);
        }

        Arrays.sort(works);

        int startTime = works[0].s;

        for(int i=0; i<N; i++){
            startTime = Math.min(startTime, works[i].s);
            startTime -= works[i].p;
        }

        bw.write(startTime < 0 ? "-1" : startTime +"");
        bw.flush();
    }

}