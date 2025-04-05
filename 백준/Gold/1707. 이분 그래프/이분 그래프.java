
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        testCase : for(int test_case=0; test_case<T; test_case++) {

            String[] input = br.readLine().split(" ");

            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            int[] map = new int[V+1];

            List<Integer>[] lists = new List[V+1];

            for(int i=1; i<=V; i++){
                lists[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++){
                input = br.readLine().split(" ");

                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);

                lists[u].add(v);
                lists[v].add(u);
            }

            Deque<int[]> deque = new ArrayDeque<>();

            boolean[] visited = new boolean[V+1];
            visited[1] = true;

            for(int i=1; i<=V; i++) {

                if(!visited[i]) {
                    deque.add(new int[]{i, 1});
                    visited[i] = true;
                }

                while (!deque.isEmpty()) {

                    int[] temp = deque.pollFirst();

                    for (Integer index : lists[temp[0]]) {
                        if (map[index] == 0) {
                            map[index] = (temp[1] == 1) ? 2 : 1;
                            if (!visited[index]) {
                                deque.addLast(new int[]{index, map[index]});
                                visited[index] = true;
                            }
                            continue;
                        }
                        if (map[index] == temp[1]) {
                            bw.write("NO\n");
                            continue testCase;
                        }
                    }

                }
            }

            bw.write("YES\n");

        }

        bw.flush();

    }

}
