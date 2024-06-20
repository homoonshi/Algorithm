
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        separate();
        int result = build();

        bw.write(result+"");
        bw.flush();
    }

    public static void separate(){

        Deque<int[]> deque = new ArrayDeque<>();
        int[] temp;
        int nx, ny;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int index = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]!=1) continue;
                deque.addLast(new int[]{i,j});
                index++;
                map[i][j]=index;
                while(!deque.isEmpty()){
                    temp = deque.pollLast();
                    for(int m=0; m<4; m++){
                        nx = temp[0] + dx[m];
                        ny = temp[1] + dy[m];

                        if(!isIn(nx,ny)) continue;

                        if(map[nx][ny]!=1) continue;
                        map[nx][ny]=index;
                        deque.addLast(new int[]{nx,ny});
                    }
                }
            }
        }

    }

    public static int build(){

        int result = Integer.MAX_VALUE;
        int currentIndex;

        int[] temp;
        Deque<int[]> deque = new ArrayDeque<>();

        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};

        int nx, ny;
        int[][] visit;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0) continue;
                visit = new int[N][N];
                deque.addLast(new int[]{i,j,0});
                visit[i][j]=1;
                currentIndex = map[i][j];
                while(!deque.isEmpty()){
                    temp = deque.pollFirst();
                    if(temp[2]>=result){
                        continue;
                    }
                    for(int m=0; m<4; m++){
                        nx = temp[0] + dx[m];
                        ny = temp[1] + dy[m];

                        if(!isIn(nx,ny)||visit[nx][ny]==1) continue;

                        if(map[nx][ny]!=0&&map[nx][ny]!=currentIndex){
                            result = Math.min(result, temp[2]);
                        }

                        if(map[nx][ny]==0){
                            deque.addLast(new int[]{nx,ny,temp[2]+1});
                            visit[nx][ny]=1;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static boolean isIn(int x,int y){
        if(x>=0&&x<N&&y>=0&&y<N){
            return true;
        }
        return false;
    }

}
