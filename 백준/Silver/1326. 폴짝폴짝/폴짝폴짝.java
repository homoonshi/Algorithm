
import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] bridge = new int[N+1];
        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            bridge[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]) - 1;
        int b = Integer.parseInt(input[1]) - 1;

        boolean[] visit = new boolean[N+1];

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{a, 0});
        visit[a] = true;
        int result = 0;

        while(!deque.isEmpty()){

            int[] temp = deque.pollFirst();
            int index = temp[0];
            int multiple = bridge[index];

            if((b-index)%multiple==0 || multiple==1){
                result = temp[1]+1;
                break;
            }

            int nextIndex = index + multiple;
            
            while (nextIndex<N){
                if(!visit[nextIndex]){
                    deque.addLast(new int[]{nextIndex, temp[1]+1});
                    visit[nextIndex] = true;
                }
                nextIndex += multiple;
            }

            nextIndex = index - multiple;

            while(nextIndex>=0){
                if(!visit[nextIndex]){
                    deque.addLast(new int[]{nextIndex, temp[1]+1});
                    visit[nextIndex] = true;
                }
                nextIndex -= multiple;
            }

        }

        if(result==0) {
            bw.write("-1");
        }else{
            bw.write(result+"");
        }

        bw.flush();

    }

}
