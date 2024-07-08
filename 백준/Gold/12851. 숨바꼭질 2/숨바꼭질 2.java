
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int time;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        time = 0;
        int result = 0;

        if(N!=K) {
            result = bfs();
        }else{
            result = 1;
        }

        bw.write(time+"\n");
        bw.write(result+"");
        bw.flush();

    }

    public static int bfs(){

        int[] go = {1,-1,2};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{N, 0});

        int[] visited = new int[100001];

        int count = 0;
        int[] temp;
        int num = 0;

        while(!deque.isEmpty()){

            temp = deque.pollFirst();
            int t = temp[1] + 1;

            for(int i=0; i<3; i++){

                if(i!=2){
                    num = temp[0] + go[i];
                }else{
                    num = temp[0] * go[i];
                }

                if( time != 0 && time < t ){
                    break;
                }

                if(num == K){
                    count++;
                    time = t;
                }

                if(num<0 || num > 100000 || (visited[num]!=0&&visited[num]<t)){
                    continue;
                }

                visited[num] = t;
                deque.addLast(new int[] {num, t});

            }

        }

        return count;
    }

}
