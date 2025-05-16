
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static boolean[] res;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        res = new boolean[N+1];

        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++){
            DFS(i);
        }

        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            if(res[i]){
                count++;
                deque.addLast(i);
            }
        }

        bw.write(count+"\n");

        while(!deque.isEmpty()){
            bw.write(deque.pollFirst()+"\n");
        }

        bw.flush();
    }

    public static void DFS(int start){

        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        int resNum = 0;
        int resIndex = 0;

        deque.addLast(start);

        while(!deque.isEmpty()){
            int index = deque.pollFirst();

            if(!visited[index]){
                visited[index] = true;
                resIndex += index;
                resNum += nums[index];
                deque.addLast(nums[index]);
            }

            if(nums[index]==index){
                break;
            }
        }

        if(resIndex==resNum){
            for(int i=1; i<=N; i++){
                if(visited[i]){
                    res[i] = true;
                }
            }
        }

    }

}