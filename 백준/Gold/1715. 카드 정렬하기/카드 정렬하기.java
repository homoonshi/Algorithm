
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> nums =new PriorityQueue<>();

        for(int i=0; i<N; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        int res = 0;

        while(nums.size()>=2){
            int sum = nums.poll();
            sum += nums.poll();
            res += sum;
            nums.add(sum);
        }

        bw.write(res+"");
        bw.flush();

    }
}