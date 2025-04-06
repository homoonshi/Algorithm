
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] res = new int[N][N];

        for(int i=0; i<N; i++){
            boolean[] visited = new boolean[N];
            Deque<Integer> deque = new ArrayDeque<>();
            for(int j=0; j<N; j++){
                if(i==j) continue;
                if(map[i][j]==1) {
                    deque.add(j);
                    visited[j] = true;
                    res[i][j] = 1;
                }
            }
            while(!deque.isEmpty()){
                int index = deque.pollFirst();
                for(int j=0; j<N; j++){
                    if(index==j) continue;
                    if(map[index][j]==1 && !visited[j]){
                        deque.add(j);
                        visited[j] = true;
                        res[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(res[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();

    }

}
