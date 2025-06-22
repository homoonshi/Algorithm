import java.io.*;
import java.util.*;

public class Main {

    static class Box implements Comparable<Box> {

        int depart, arrive;
        int count;

        public Box(int depart, int arrive, int count) {
            this.depart = depart;
            this.arrive = arrive;
            this.count = count;
        }

        @Override
        public int compareTo(Box o) {
            return this.arrive == o.arrive ? this.depart - o.depart : this.arrive - o.arrive;
        }
    }

    static int N, C;
    static int M;
    static PriorityQueue<Box> boxes;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        M = Integer.parseInt(br.readLine());

        boxes = new PriorityQueue<>();

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            int d = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            boxes.add(new Box(d, a, c));
        }

        int[] current = new int[N+1];
        long res = 0;

        while(!boxes.isEmpty()){

            Box box = boxes.poll();

            int min = C;

            for(int i=box.depart; i<box.arrive; i++){
                min = Math.min(min, C-current[i]);
            }

            if(min==0){
                continue;
            }

            if(min >= box.count){
                for(int i=box.depart; i<box.arrive; i++){
                    current[i] += box.count;
                }
                res += box.count;
            }else{
                for(int i=box.depart; i<box.arrive; i++){
                    current[i] += min;
                }
                res += min;
            }

        }

        bw.write(res+"");
        bw.flush();

    }
}