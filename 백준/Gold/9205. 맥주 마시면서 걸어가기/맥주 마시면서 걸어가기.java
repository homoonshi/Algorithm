import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int testcase = 0; testcase < T; testcase++){

            int n = Integer.parseInt(br.readLine()) + 2;
            int[][] info = new int[n][2];

            List<Integer>[] next = new List[n];

            for(int i=0; i<n; i++){
                String[] input = br.readLine().split(" ");
                info[i][0] = Integer.parseInt(input[0]);
                info[i][1] = Integer.parseInt(input[1]);
                next[i] = new ArrayList<>();
                for(int j=0; j<i; j++){
                    int distance = Math.abs(info[j][0]-info[i][0]) +
                            Math.abs(info[j][1]-info[i][1]);
                    if(distance<=1000){
                        next[i].add(j);
                        next[j].add(i);
                    }
                }
            }

            boolean[] visit = new boolean[n];

            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(0);
            visit[0] = true;

            boolean res = false;

            loof : while(!deque.isEmpty()){
                int index = deque.pollFirst();
                for(int i=0; i<next[index].size(); i++){
                    int nextIndex = next[index].get(i);
                    if(visit[nextIndex]) continue;
                    if(nextIndex==n-1){
                        res = true;
                        break loof;
                    }
                    deque.add(nextIndex);
                    visit[nextIndex] = true;
                }
            }

            bw.write(res ? "happy\n" : "sad\n");

        }

        bw.flush();
    }

}