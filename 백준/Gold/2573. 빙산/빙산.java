
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        deque = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]>0){
                    deque.add(i+(j*1000));
                }
            }
        }

        int res = 0;

        while(true){
            if(!hot()){
                break;
            }
            if(deque.isEmpty()){
                res = 0;
                break;
            }
            res++;
        }

        bw.write(res+"");
        bw.flush();

    }

    public static boolean hot(){

        boolean[][] visit = new boolean[N][M];
        Deque<Integer> temp = new ArrayDeque<>();

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        boolean check = false;

        while(!deque.isEmpty()){

            int index = deque.pollFirst();

            int t1 = index%1000;
            int t2 = index/1000;

            if(check && !visit[t1][t2]){
                return false;
            }

            if(visit[t1][t2] && map[t1][t2]>0){
                temp.add(index);
                continue;
            }

            visit[t1][t2] = true;

            Deque<int[]> next = new ArrayDeque<>();
            next.add(new int[]{t1, t2});
            check = true;

            while(!next.isEmpty()){

                int[] t = next.pollFirst();

                int n = t[0];
                int m = t[1];

                int c = 0;

                for(int i=0; i<4; i++){

                    int nx = n + dx[i];
                    int ny = m + dy[i];

                    if(!isIn(nx, ny) || visit[nx][ny]) continue;

                    if(map[nx][ny]==0){
                        c++;
                    }else{
                        next.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }

                }

                if(map[n][m] > c) {
                    map[n][m] -= c;
                }else{
                    map[n][m] = 0;
                }

            }

            if(map[t1][t2]>0){
                temp.add(index);
            }

        }

        deque = temp;
        return true;
    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }

}