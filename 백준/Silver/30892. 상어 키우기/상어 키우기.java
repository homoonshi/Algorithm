
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        long T = Long.parseLong(input[2]);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){

            long num = Long.parseLong(input[i]);
            pq.add(num);

        }

        int k = 0;
        Deque<Long> deque = new ArrayDeque<>();

        while(k<K){
            
            while(!pq.isEmpty() && pq.peek() < T){
                deque.addLast(pq.poll());
            }
            
            if(deque.isEmpty()){
                break;
            }
            
            T += deque.pollLast();
            k++;

        }

        bw.write(T+"");
        bw.flush();

    }

}
