
import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        String[][] map = new String[N][N];
        int[][] max = new int[N][N];
        int[][] min = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().split(" ");
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        max[0][0] = Integer.parseInt(map[0][0]);
        min[0][0] = Integer.parseInt(map[0][0]);

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        while (!deque.isEmpty()){

            int[] temp = deque.pollFirst();

            for(int i=0; i<2; i++){

                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(!isIn(nx, ny)){
                    continue;
                }

                for(int j=0; j<2; j++){

                    int fx = nx + dx[j];
                    int fy = ny + dy[j];

                    if(!isIn(fx, fy)){
                        continue;
                    }

                    int beforeMax = max[temp[0]][temp[1]];
                    int beforeMin = min[temp[0]][temp[1]];
                    int after = Integer.parseInt(map[fx][fy]);

                    int resultMax = cal(map[nx][ny], beforeMax, after);
                    int resultMin = cal(map[nx][ny], beforeMin, after);

                    // max
                    max[fx][fy] = Math.max(max[fx][fy], resultMax);
                    // min
                    min[fx][fy] = Math.min(min[fx][fy], resultMin);

                    if(!visited[fx][fy]){
                        deque.addLast(new int[]{fx,fy});
                        visited[fx][fy] = true;
                    }

                }

            }
        }

        bw.write(max[N-1][N-1]+" "+min[N-1][N-1]);
        bw.flush();

    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }
        return false;
    }

    public static int cal(String c, int a, int b){
        switch (c) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
        }
        return 0;
    }

}
