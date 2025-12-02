import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> deque = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));
        long res = 0;

        for(int i=0; i<N; i++){
            int nums = Integer.parseInt(br.readLine());
            int size = deque.size();
            for(int j=0; j<size; j++){
                int[] temp = deque.poll();

                int height = temp[0];
                int index  = temp[1];

                if(height<=nums){
                    res += i - index;
                    continue;
                }

                deque.add(temp);
                break;
            }
            deque.add(new int[]{nums, i+1});
        }

        while(!deque.isEmpty()){
            int[] temp = deque.poll();
            res += N - temp[1];
        }

        bw.write(res+"");
        bw.flush();

    }
}