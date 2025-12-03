import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] nums = new int[N];

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            nums[i] = n;
        }

        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i=1; i<N; i++){
            int distance = nums[i] - nums[i-1];
            pq.add(distance);
        }

        long res = 0;

        for(int i=0; i<N-K; i++){
            res += pq.poll();
        }

        res += K;

        bw.write(res+"");
        bw.flush();

    }
}