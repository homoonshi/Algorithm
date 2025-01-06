
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] position;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        position = new int[N];
        visited = new boolean[N];
        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        result = 0;
        track(0, 0);

        bw.write(result+"");
        bw.flush();

    }

    public static void track(int depth, int sum){

        if(depth == N){
            result = Math.max(result, sum);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                position[depth] = nums[i];
                int add = Math.abs((depth==0) ? 0 : position[depth-1] - position[depth]);
                track(depth+1, sum+add);
                visited[i] = false;
            }
        }

    }

}
