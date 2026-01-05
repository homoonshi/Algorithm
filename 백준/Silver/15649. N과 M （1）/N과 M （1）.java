import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static int N, M;
    static int[] nums;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visit = new boolean[N+1];
        nums = new int[M];

        recursion(0);

        bw.flush();

    }

    public static void recursion(int depth) throws IOException {
        if(depth==M){
            for(int i=0; i<M; i++){
                bw.write(nums[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            if(visit[i]) continue;
            nums[depth] = i;
            visit[i] = true;
            recursion(depth+1);
            visit[i] = false;
        }
    }

}