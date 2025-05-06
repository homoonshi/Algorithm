
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] ban = new int[N];
        List<Long[]>[] map = new List[N];
        long[] distance = new long[N];

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            ban[i] = Integer.parseInt(input[i]);
            map[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long d = Long.parseLong(input[2]);

            if(a==N-1 || b==N-1 || ban[a]==0 && ban[b]==0){
                map[a].add(new Long[]{(long) b, d});
                map[b].add(new Long[]{(long) a, d});
            }

        }

        PriorityQueue<Long[]> pq = new PriorityQueue<>(new Comparator<Long[]>() {
            @Override
            public int compare(Long[] o1, Long[] o2) {
                return (int) (o1[1] - o2[1]);
            }
        });
        pq.add(new Long[]{0L, 0L});

        Long res = -1L;

        while(!pq.isEmpty()){

            Long[] p = pq.poll();
            if(distance[Math.toIntExact(p[0])]<p[1]){
                continue;
            }

            for (Long[] temp : map[Math.toIntExact(p[0])]) {
                if(distance[Math.toIntExact(temp[0])]>p[1]+temp[1]) {
                    pq.add(new Long[]{temp[0], p[1] + temp[1]});
                    distance[Math.toIntExact(temp[0])] = p[1] + temp[1];
                }
            }

        }

        if(distance[N-1] != Long.MAX_VALUE){
        res = distance[N-1];
        }

        bw.write(res+"");
        bw.flush();

    }
}