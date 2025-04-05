
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int X = Integer.parseInt(input[3]);

        int[] distance = new int[N+1];

        List<Integer>[] lists = new List[N+1];

        for(int i=1; i<=N; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            lists[a].add(b);

        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{X, 0});
        
        distance[X]=-1;

        while(!deque.isEmpty()){

            int[] temp = deque.pollFirst();

            for (Integer next : lists[temp[0]]) {

                if(distance[next]==0){
                    distance[next] = temp[1]+1;
                    if(temp[1]+1<K){
                        deque.addLast(new int[]{next, temp[1]+1});
                    }
                }

            }

        }

        int res = 0;

        for (int i = 1; i <= N; i++) {
            if(distance[i]==K){
                bw.write(i+"\n");
                res++;
            }
        }

        if(res==0){
            bw.write("-1");
        }
        bw.flush();

    }

}
