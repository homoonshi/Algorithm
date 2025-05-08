
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<int[]>[] map = new List[N+1];
        int[] res = new int[N+1];

        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
            res[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);

            map[a].add(new int[]{b, d});
            map[b].add(new int[]{a, d});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int[] t : map[1]){
            pq.add(new int[]{t[0], t[1]});
            res[t[0]] = Math.min(res[t[0]], t[1]);
        }

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int index = temp[0];
            int distance = temp[1];

            if(distance > res[index]){
                continue;
            }

            for(int[] t : map[index]){

                int d = distance + t[1];

                if(index==t[0] || d >= res[t[0]]){
                    continue;
                }

                pq.add(new int[]{t[0], d});
                res[t[0]] = d;

            }
        }

        bw.write(res[N]+"");
        bw.flush();

    }
}