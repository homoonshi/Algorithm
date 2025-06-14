
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] visit = new int[100001];

        Arrays.fill(visit, Integer.MAX_VALUE);

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{N, 0});
        
        if(N==K){
            bw.write(0+"");
            bw.flush();
            return;
        }

        while(!deque.isEmpty()){

            int[] temp = deque.pollFirst();

            int posi = temp[0];
            int sec = temp[1];

            if(visit[posi] < sec){
                continue;
            }

            if(posi+1<=100000 && visit[posi+1] > sec+1){
                deque.addLast(new int[]{posi+1, sec+1});
                visit[posi+1] = sec+1;
            }

            if(posi-1>=0 && visit[posi-1] > sec+1){
                deque.addLast(new int[]{posi-1, sec+1});
                visit[posi-1] = sec+1;
            }

            if(posi*2<=100000 && visit[posi*2] > sec){
                deque.addLast(new int[]{posi*2, sec});
                visit[posi*2] = sec;
            }

        }

        bw.write(visit[K]+"");
        bw.flush();

    }
}