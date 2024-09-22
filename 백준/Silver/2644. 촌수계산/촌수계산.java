
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] map = new List[n+1];

        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){

            input = br.readLine().split(" ");

            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);

            map[parent].add(child);
            map[child].add(parent);

        }

        int[] visit = new int[n+1];

        Deque<int[]> deque = new ArrayDeque<>();

        int result = 0;

        deque.add(new int[]{x, result});
        visit[x] = 1;

        while(!deque.isEmpty()){

            int[] temp = deque.pollFirst();

            for(int family : map[temp[0]]){

                if(visit[family]==1){
                    continue;
                }

                if(family==y){
                    result = temp[1] + 1;
                    bw.write(result+"");
                    bw.flush();
                    return;
                }

                deque.add(new int[]{family, temp[1]+1});
                visit[family]=1;

            }

        }

        bw.write("-1");
        bw.flush();

    }

}
