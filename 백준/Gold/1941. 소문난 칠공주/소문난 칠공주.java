import java.io.*;
import java.util.*;

public class Main {

    static char[][] map = new char[5][5];
    static int[][] visit = new int[5][5];
    static int[][] complete = new int[5][5];
    static Set<Integer> bitVisit = new HashSet<>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int res;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        for(int i=0; i<5; i++){
            input = br.readLine();
            for(int j=0; j<5; j++){
                map[i][j] = input.charAt(j);
            }
        }

        res = 0;

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                visit[i][j]=1;
                if(map[i][j]=='S'){
                    combination(1,1, 1<<(i*5+j),i,j);
                }else{
                    combination(1,0,1<<(i*5+j),i,j);
                }
                visit[i][j]=0;
                complete[i][j]=1;
            }
        }

        bw.write(res+"");
        bw.flush();

    }

    public static void combination(int cnt, int dasom, int bit, int x, int y){

        if(cnt==7){
            if(dasom<4) return;
            if(!bitVisit.contains(bit)){
                if(BFS(x,y)) {
                    res++;
                    bitVisit.add(bit);
                }
            }
            return;
        }

        int init = 0;

        for(int i=x; i<5; i++){
            for(int j=0; j<5; j++){
                if(i==x && init==0){
                    j=y;
                    init=1;
                }
                if(visit[i][j]==1||complete[i][j]==1) continue;
                visit[i][j]=1;
                if(map[i][j]=='S'){
                    combination(cnt+1,dasom+1, bit|(1<<(i*5+j)),i,j);
                }else{
                    combination(cnt+1,dasom, bit|(1<<(i*5+j)),i,j);
                }
                visit[i][j]=0;
            }
        }

    }

    public static boolean BFS(int x,int y){

        int nx, ny;
        Deque<int[]> deque = new ArrayDeque<>();
        int[] temp;
        deque.add(new int[] {x,y});

        int count = 0;

        int[][] visitBFS = new int[5][5];

        while(!deque.isEmpty()){

            temp = deque.pollFirst();

            for(int i=0; i<4; i++){

                nx = temp[0] + dx[i];
                ny = temp[1] + dy[i];

                if(!isIn(nx,ny)) continue;
                if(visit[nx][ny]==0) continue;
                if(visitBFS[nx][ny]==1) continue;

                visitBFS[nx][ny]=1;
                count++;

                deque.add(new int[] {nx,ny});

            }

        }


        if(count==7){
            return true;
        }

        return false;
    }

    public static boolean isIn(int x, int y){
        if(x>=0&&x<5&&y>=0&&y<5){
            return true;
        }
        return false;
    }

}