import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<Integer>[] city = new List[N+1];
        Set<Integer> fire = new HashSet<>();

        for(int i=1; i<=N; i++){
            city[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            city[a].add(b);
            city[b].add(a);
        }

        int K = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        for(int i=0; i<K; i++){
            fire.add(Integer.parseInt(input[i]));
        }

        boolean[] res = new boolean[N+1];
        Deque<Integer> boom = new ArrayDeque<>();

        loof : for(int i=1; i<=N; i++){
            if(!fire.contains(i)) continue;
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(i);
            for(Integer index : city[i]){
                if(!fire.contains(index))
                    continue loof;
                deque.add(index);
            }
            while(!deque.isEmpty()){
                int t = deque.poll();
                res[t] = true;
            }
            boom.add(i);
        }

        int count = 0;

        for(int i=1; i<=N; i++){
            if(!fire.contains(i)) continue;
            if(!res[i]) {
                break;
            }
            count++;
        }

        if(count==fire.size()){
            bw.write(boom.size()+"\n");
            while(!boom.isEmpty()){
                bw.write(boom.pollFirst()+" ");
            }
        }else{
            bw.write("-1");
        }

        bw.flush();
    }
}