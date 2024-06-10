
import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] map;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String inputs;

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N+1][M+1];

        for(int i=0; i<N; i++){
            inputs = br.readLine();
            for(int j=0; j<M; j++){
                map[i+1][j+1] = inputs.charAt(j)-'0';
            }
        }

        map[N][M]=9;

        int result;

        if(N==1&&M==1) {
            result = 1;
        }else{
            result = BFS();
        }

        bw.write(result+"");
        bw.flush();

    }

    public static int BFS(){

        Deque<int[]> deque = new ArrayDeque<>();
        int[] temp;
        int[][] visit = new int[N+1][M+1];
        visit[1][1] = 1;

        int x,y,t,b;
        int bIndex = 1;
        deque.add(new int[]{1,1,1,0});

        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};

        while(!deque.isEmpty()){

            temp = deque.pollFirst();

            for(int i=0; i<4; i++){

                x = temp[0] + dx[i];
                y = temp[1] + dy[i];
                t = temp[2] + 1;
                b = temp[3];

                if(!isIn(x,y)||(visit[x][y]&1)!=0||((visit[x][y]&(1<<b))!=0)) continue;

                if(map[x][y]==0){
                    deque.addLast(new int[]{x, y, t, b});
                    visit[x][y] |= (1 << b);
                }else if (map[x][y]==1 && b==0){
                    deque.addLast(new int[]{x, y, t, bIndex});
                    visit[x][y] |= (1 << bIndex);
                }else if(map[x][y]==9){
                    return t;
                }

            }


        }

        return -1;
    }

    public static boolean isIn(int x,int y){
        if(x>=1&&x<=N&&y>=1&&y<=M){
            return true;
        }
        return false;
    }


}
