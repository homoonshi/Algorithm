
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){

            int num = Integer.parseInt(br.readLine());

            if(num==0){
                if(pq.isEmpty()){
                    bw.write(0+"\n");
                    continue;
                }
                bw.write(pq.poll()+"\n");
                continue;
            }

            pq.add(num);

        }


        bw.flush();
    }

}
