import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        input = br.readLine().split(" ");
        int[] nums = new int[N];

        boolean[] has = new boolean[1001];
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(S);
        has[S] = true;
        int res = -1;

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
            int size = deque.size();
            has = new boolean[1001];
            for(int j=0; j<size; j++){
                int n = deque.pollFirst();
                int sub = n - nums[i];
                int sum = n + nums[i];
                if(0 <= sub && sub <= M && !has[sub]){
                    deque.addLast(sub);
                    has[sub] = true;
                }
                if(0 <= sum && sum <= M && !has[sum]){
                    deque.addLast(sum);
                    has[sum] = true;
                }
                if(i==N-1){
                    if(sub>=0 && sub <= M && has[sub]) {
                        res = Math.max(res, sub);
                    }
                    if(sum>=0 && sum <= M && has[sum]){
                        res = Math.max(res, sum);
                    }
                }
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}