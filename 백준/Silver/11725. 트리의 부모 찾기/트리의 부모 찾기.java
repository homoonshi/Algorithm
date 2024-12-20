
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> list[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new List[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){

            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            list[a].add(b);
            list[b].add(a);

        }

        int[] visited = new int[N+1];
        visited[1] = 1;

        int[] parents = new int[N+1];

        Deque<Integer> deque = new ArrayDeque<>();

        for(int n : list[1]){
            deque.add(n);
            parents[n]=1;
        }

        while(!deque.isEmpty()){

            int num = deque.pollFirst();
            visited[num] = 1;

            for(int n : list[num]){
                if(visited[n]==0){
                    deque.addLast(n);
                    parents[n]=num;
                }
            }

        }

        for(int i=2; i<=N; i++){
            bw.write(parents[i]+"\n");
        }

        bw.flush();

    }


}
