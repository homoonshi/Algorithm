
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case<T; test_case++){

            int K = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i=0; i<K; i++){

                pq.add(Long.parseLong(input[i]));

            }

            long result = 0;

            while(pq.size()!=1){

                long n1 = pq.poll();
                long n2 = pq.poll();

                long sum = n1 + n2;

                result += sum;
                pq.add(sum);

            }

            bw.write(result+"\n");

        }

        bw.flush();

    }

}
