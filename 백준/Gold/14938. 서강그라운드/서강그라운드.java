
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        int[] item = new int[n+1];

        input = br.readLine().split(" ");

        for(int i=1; i<=n; i++){
            item[i] = Integer.parseInt(input[i-1]);
        }

        int[][] dist = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<r; i++){

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int l = Integer.parseInt(input[2]);

            dist[a][b] = l;
            dist[b][a] = l;

        }

        for(int i=1; i<=n; i++){

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

            for(int j=1; j<=n; j++) {
                if(i==j || dist[i][j]==Integer.MAX_VALUE) continue;
                pq.add(new int[]{j, dist[i][j]});
            }

            while (!pq.isEmpty()){

                int[] temp = pq.poll();
                int index = temp[0];
                int d = temp[1];

                if(d>dist[i][index]){
                    continue;
                }

                for(int j=1; j<=n; j++){

                    if(i==j || j==index || dist[index][j]==Integer.MAX_VALUE) continue;

                    if(d + dist[index][j] > m || d + dist[index][j] >= dist[i][j]){
                        continue;
                    }

                    pq.add(new int[]{j, d+dist[index][j]});
                    dist[i][j] = d + dist[index][j];

                }

            }

        }

        int res = 0;

        for(int i=1; i<=n; i++){

            int temp = item[i];

            for(int j=1; j<=n; j++){

                if(i==j || dist[i][j]>m) continue;

                temp += item[j];

            }

            res = Math.max(res, temp);

        }

        bw.write(res+"");
        bw.flush();

    }
}