import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        List<Integer> list[] = new List[N];

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
            int jump = Integer.parseInt(input[i]);

            int min = i-jump < 0 ? i : i-jump;
            int max = i+jump >= N ? i : i+jump;

            if(min!=i) list[i].add(min);
            if(max!=i) list[i].add(max);
        }

        int start = Integer.parseInt(br.readLine()) - 1;
        int res = 1;
        boolean[] visit = new boolean[N];
        visit[start] = true;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        while(!deque.isEmpty()){
            int next = deque.poll();
            for(Integer index : list[next]){
                if(visit[index]) continue;
                deque.add(index);
                visit[index] = true;
                res++;
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}