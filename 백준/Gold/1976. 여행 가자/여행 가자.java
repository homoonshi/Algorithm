
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static Deque<Integer>[] map;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new Deque[N+1];

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            map[i] = new ArrayDeque<>();
            for(int j=1; j<=N; j++){
                if(Integer.parseInt(input[j-1])==1){
                    map[i].add(j);
                }
            }
        }

        input = br.readLine().split(" ");

        int goal;
        Deque<Integer> deque = new ArrayDeque<>();
        boolean find = false;

        int city = 0;
        int[] visit;

        for(int i=1; i<M; i++){

            goal = Integer.parseInt(input[i]);
            deque.add(Integer.parseInt(input[i-1]));
            find = false;
            visit = new int[N+1];

            if(goal==deque.peekFirst()){
                deque.clear();
                city++;
                continue;
            }

            while(!deque.isEmpty()){

                int num = deque.pollFirst();
                visit[num] = 1;
                int size = map[num].size();

                for(int j=0; j<size; j++){

                    int next = map[num].pollFirst();
                    map[num].addLast(next);

                    if(visit[next]==1){
                        continue;
                    }

                    deque.addLast(next);

                    if(goal==next){
                        city++;
                        deque.clear();
                        find = true;
                        break;
                    }

                }

            }

            if(!find){
                break;
            }

        }

        if(city==M-1){
            bw.write("YES");
        }else{
            bw.write("NO");
        }

        bw.flush();



    }

}
