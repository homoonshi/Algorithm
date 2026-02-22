import java.io.*;
import java.util.*;

public class Main {

    static class Test implements Comparable<Test>{
        int start;
        int score;
        Test(int start, int score){
            this.start = start;
            this.score = score;
        }
        @Override
        public int compareTo(Test o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Test> pq = new PriorityQueue<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] start = br.readLine().split(" ");
        String[] score = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            pq.add(new Test(
                    Integer.parseInt(start[i]),
                    Integer.parseInt(score[i])
            ));
        }

        int time = 0;
        int res = 0;

        while(!pq.isEmpty() && time<N*24){
            Test study = pq.poll();
            int current = study.start;
            while(current+study.score<=100){
                time++;
                current += study.score;
                if(time==N*24){
                    break;
                }
            }
            if(current!=100){
                study.start = current;
                study.score = 100-current;
                pq.add(study);
                continue;
            }
            res += current;
        }

        while(!pq.isEmpty()){
            Test test = pq.poll();
            res += test.start;
        }

        bw.write(res+"");
        bw.flush();

    }
}