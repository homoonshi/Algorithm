import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int i=1; i<=N; i++){

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            for(int j=1; j<=N; j++){
               if(i==j || map[i][j]==Integer.MAX_VALUE) continue;
               pq.add(new int[]{map[i][j], j});
            }

            while(!pq.isEmpty()){

                int[] temp = pq.poll();
                int distance = temp[0];
                int index = temp[1];

                for(int j=1; j<=N; j++){
                    if(i==j || j==index || map[index][j]==Integer.MAX_VALUE) continue;

                    int d = distance + map[index][j];

                    if(map[i][j] > d){
                        map[i][j] = d;
                        pq.add(new int[]{d, j});
                    }
                }

            }

        }

        int min = Integer.MAX_VALUE;
        int res = 0;

        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                if(i==j) continue;
                sum += map[i][j];
            }
            if(sum<min){
                min = sum;
                res = i;
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}