
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Integer[] student = new Integer[N];

        for(int i=0; i<N; i++){
            student[i] = Integer.parseInt(input[i]);
        }

        int currentTime = 1;
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(student, Collections.reverseOrder());

        for(int i=0; i<N; i++){

            while(!pq.isEmpty() && currentTime == pq.peek()){
                pq.poll();
            }

            pq.add(currentTime + student[i]);
            currentTime++;
            result = Math.max(result, pq.size());

        }

        bw.write(result+"");
        bw.flush();

    }

}
