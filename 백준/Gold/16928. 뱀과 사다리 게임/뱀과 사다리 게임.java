import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int[] map = new int[101];

        int n = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
        int[] go = new int[n+1];

        for(int i=1; i<=n; i++){
            input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            go[i] = end;
            map[start] = i;
        }

        boolean[] visited = new boolean[101];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{1, 0});

        while(!deque.isEmpty()){

            int[] t = deque.pollFirst();
            int index = t[0];
            int count = t[1];

            for(int i=1; i<=6; i++){

                int next = index + i;

                if(visited[next] || next > 100) continue;
                if(next==100){
                    bw.write(count+1+"");
                    bw.flush();
                    return;
                }

                if(map[next]!=0){
                    if(visited[go[map[next]]]) continue;
                    if(go[map[next]]==100){
                        bw.write(count+1+"");
                        bw.flush();
                        return;
                    }
                    deque.addLast(new int[]{go[map[next]], count+1});
                    visited[go[map[next]]] = true;
                    continue;
                }

                visited[next] = true;
                deque.addLast(new int[]{next, count+1});

            }

        }

    }
}