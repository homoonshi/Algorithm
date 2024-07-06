
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] start;
    static int[][] map;
    static Deque<int[]> cheese = new ArrayDeque<>();
    static Deque<int[]> inAir = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        start = new int[N][M];
        map = new int[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                start[i][j] = Integer.parseInt(input[j]);
                if(start[i][j]==1){
                    cheese.addLast(new int[]{i,j});
                }
            }
        }

        boolean outAir = false;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!outAir&&start[i][j]==0){
                    initMap(i,j,1);
                    outAir = true;
                }else if(outAir&&start[i][j]==0&&map[i][j]==0){
                    initMap(i,j,3);
                }else if(start[i][j]==1){
                    initMap(i,j,2);
                }
            }
        }

        int result = 0;

        while(!cheese.isEmpty()){
            result++;
            removeCheese();
            if(!inAir.isEmpty()){
                inOutAir();
            }
        }

        bw.write(result+"");
        bw.flush();

    }

    public static void inOutAir(){

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int nx, ny;
        int length = inAir.size();

        for(int i=0; i<length; i++){
            int temp[] = inAir.pollFirst();

            if(map[temp[0]][temp[1]]==3) {
                for (int j = 0; j < 4; j++) {
                    nx = temp[0] + dx[j];
                    ny = temp[1] + dy[j];

                    if (!isIn(nx, ny)) {
                        continue;
                    }
                    if (map[nx][ny] == 1) {
                        map[temp[0]][temp[1]] = 1;
                        break;
                    }
                }
                if (map[temp[0]][temp[1]] == 3) {
                    inAir.addLast(new int[]{temp[0], temp[1]});
                }
            }

            if(map[temp[0]][temp[1]]==1){
                Deque<int[]> deque = new ArrayDeque<>();
                deque.addLast(new int[]{temp[0],temp[1]});

                while(!deque.isEmpty()){

                    temp = deque.pollFirst();

                    for(int j=0; j<4; j++){

                        nx = temp[0] + dx[j];
                        ny = temp[1] + dy[j];

                        if(!isIn(nx,ny)||map[nx][ny]==1||map[nx][ny]==2){
                            continue;
                        }

                        map[nx][ny]=1;
                        deque.addLast(new int[]{nx,ny});

                    }

                }
            }
        }
    }
    public static void removeCheese(){

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int[] temp;
        int nx, ny;

        int length = cheese.size();
        Deque<int[]> deadCheese = new ArrayDeque<>();

        for(int i=0; i<length; i++){

            temp = cheese.pollFirst();
            int count = 0;

            for(int j=0; j<4; j++){

                nx = temp[0] + dx[j];
                ny = temp[1] + dy[j];

                if(!isIn(nx,ny)){
                    continue;
                }

                if(map[nx][ny]==1){
                    count++;
                }

            }

            if(count>=2){
                deadCheese.addLast(new int[]{temp[0],temp[1]});
            }else{
                cheese.addLast(new int[]{temp[0],temp[1]});
            }

        }

        while(!deadCheese.isEmpty()){

            temp = deadCheese.pollFirst();
            map[temp[0]][temp[1]]=1;

        }

    }

    public static void initMap(int x,int y,int c){

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x,y});
        map[x][y]=c;
        if(c==3){
            inAir.addLast(new int[]{x,y});
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int[] temp;

        int nx, ny;

        while(!deque.isEmpty()){

            temp = deque.pollLast();

            for(int i=0; i<4; i++){

                nx = temp[0] + dx[i];
                ny = temp[1] + dy[i];

                if(!isIn(nx,ny)||map[nx][ny]!=0){
                    continue;
                }

                if(((c==1||c==3)&&start[nx][ny]!=0)||((c==2)&&start[nx][ny]!=1)){
                    continue;
                }

                map[nx][ny]=c;
                deque.addLast(new int[]{nx,ny});

                if(c==3){
                    inAir.addLast(new int[]{nx,ny});
                }

            }

        }

    }

    public static boolean isIn(int x,int y){
        if(x>=0&&x<N&&y>=0&&y<M){
            return true;
        }
        return false;
    }

}
