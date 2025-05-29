
import java.io.*;
import java.util.*;

public class Main {

    static int L, R, C;
    static int[][][] map;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            String[] input = br.readLine().split(" ");

            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);

            if(L==0 && R==0 && C==0){
                break;
            }

            map = new int[L][R][C];

            int[] start = new int[3];

            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String in = br.readLine();
                    for(int k=0; k<C; k++){
                        if(in.charAt(k)=='#'){
                            map[i][j][k] = 1;
                        }else if(in.charAt(k)=='S'){
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }else if(in.charAt(k)=='E'){
                            map[i][j][k] = 2;
                        }
                    }
                }
                br.readLine();
            }

            int res = BFS(start);

            if(res==0){
                bw.write("Trapped!\n");
            }else{
                bw.write("Escaped in "+res+" minute(s).\n");
            }

        }

        bw.flush();

    }

    public static int BFS(int[] start){

        Deque<int[]> deque = new ArrayDeque<>();

        int[] dl = {1, -1};
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        deque.add(new int[]{start[0], start[1], start[2], 0});

        boolean[][][] visit = new boolean[L][R][C];
        visit[start[0]][start[1]][start[2]] = true;

        while(!deque.isEmpty()){

            int[] temp = deque.pollFirst();

            int l = temp[0];
            int x = temp[1];
            int y = temp[2];
            int r = temp[3];

            for(int i=0; i<2; i++){
                int nl = l + dl[i];
                if(!isIn(nl, x, y)) continue;
                if(visit[nl][x][y]) continue;
                if(map[nl][x][y]==1) continue;
                if(map[nl][x][y]==2) return r+1;
                visit[nl][x][y] = true;
                deque.add(new int[]{nl, x, y, r+1});
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!isIn(l, nx, ny)) continue;
                if(visit[l][nx][ny]) continue;
                if(map[l][nx][ny]==1) continue;
                if(map[l][nx][ny]==2) return r+1;
                visit[l][nx][ny] = true;
                deque.add(new int[]{l, nx, ny, r+1});
            }

        }

        return 0;
    }

    public static boolean isIn(int l, int x, int y){
        if(l>=0 && l<L && x>=0 && x<R && y>=0 && y<C){
            return true;
        }
        return false;
    }

}