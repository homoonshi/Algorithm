
import java.io.*;
import java.util.*;

public class Main {

    static boolean[] height;
    static int[] ban;
    static int[][][] map;
    static int N, res;
    static boolean[] right;
    static boolean[] left;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        res = 0;

        height = new boolean[N];
        ban = new int[N];

        map = new int[N][N][3];
        left = new boolean[2*N];
        right = new boolean[2*N];

        initLeft();
        initRight();

        recursion(0);

        bw.write(res+"");
        bw.flush();

    }

    public static void recursion(int y){

        if(y==N){
            res++;
            return;
        }

        for(int i=0; i<N; i++){
            if(height[i] || right[map[i][y][2]] || left[map[i][y][1]]) continue;
            height[i] = true;
            right[map[i][y][2]] = true;
            left[map[i][y][1]] = true;
            recursion(y+1);
            right[map[i][y][2]] = false;
            left[map[i][y][1]] = false;
            height[i] = false;
        }

    }

    public static void initLeft(){
        int x = N-1;
        int y = 0;
        for(int index=1; index<2*N; index++){
            int nx = x;
            int ny = y;
            map[nx][ny][1] = index;
            while(true){
                nx--;
                ny--;
                if(!isIn(nx, ny)){
                    break;
                }
                map[nx][ny][1] = index;
            }
            if(y!=N-1){
                y++;
            }else{
                x--;
            }
        }
    }

    public static void initRight(){
        int x = N-1;
        int y = N-1;
        for(int index=1; index<2*N; index++){
            int nx = x;
            int ny = y;
            map[nx][ny][2] = index;
            while(true){
                nx--;
                ny++;
                if(!isIn(nx, ny)){
                    break;
                }
                map[nx][ny][2] = index;
            }
            if(y!=0){
                y--;
            }else{
                x--;
            }
        }
    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }
        return false;
    }

}