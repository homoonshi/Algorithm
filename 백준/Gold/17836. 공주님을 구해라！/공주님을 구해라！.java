
import java.io.*;
import java.util.*;

public class Main {

    static int N,M,T;
    static int[][] map;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        map = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        map[N][M]=9;

        int result = BFS();

        if(result==T+1){
            bw.write("Fail");
            bw.flush();
        }else{
            bw.write(result+"");
            bw.flush();
        }

    }

    public static int BFS(){

        int time = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] visit = new int[N+1][M+1];

        int x,y,t,s;
        int[] temp;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        int swordTime=10001;
        Boolean sword = false;

        deque.add(new int[]{1,1,0,0});

        while(!deque.isEmpty()){

            temp = deque.pollFirst();

            for(int i=0; i<4; i++){

                x = temp[0] + dx[i];
                y = temp[1] + dy[i];
                t = temp[2]+1;
                s = temp[3];

                if(t>T){
                    if(swordTime>T) {
                        return T + 1;
                    }else{
                        return swordTime;
                    }
                }

                if(!isIn(x,y)||visit[x][y]==1) continue;

                if(map[x][y]==0){
                    deque.addLast(new int[]{x,y,t,s});
                    visit[x][y]=1;
                }else if(map[x][y]==2 && !sword){
                    swordTime = t + N-x + M-y;
                    sword = true;
                }else if(map[x][y]==9){
                    if(swordTime>t) {
                        return t;
                    }else{
                        return swordTime;
                    }
                }

            }

        }

        if(swordTime>T) {
            return T+1;
        }else{
            return swordTime;
        }
    }

    public static boolean isIn(int x,int y){
        if(x>=1&&x<N+1&&y>=1&&y<M+1){
            return true;
        }
        return false;
    }

}
