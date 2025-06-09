
import java.io.*;
import java.util.*;
import java.util.logging.Level;

public class Main {

    static int N;
    static int[][][] map;
    static List<int[]> lists;
    static boolean[][] has;
    static int res;

    static boolean[] left;
    static boolean[] right;

    static List<Integer>[] rights;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N][3];
        String[] input;

        lists = new ArrayList<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j][0] = Integer.parseInt(input[j]);
                if(map[i][j][0]==1){
                    lists.add(new int[]{i, j});
                }
            }
        }

        initLeft();
        initRight();

        has = new boolean[2*N][2*N];
        left = new boolean[2*N];
        right = new boolean[2*N];

        rights = new List[2*N];

        for(int i=1; i<2*N; i++){
            rights[i] = new ArrayList<>();
        }

        for(int i=0; i<lists.size(); i++){
            int[] temp = lists.get(i);
            int x = temp[0];
            int y = temp[1];
            if(!has[map[x][y][1]][map[x][y][2]]) {
                has[map[x][y][1]][map[x][y][2]] = true;
                rights[map[x][y][1]].add(map[x][y][2]);
                left[map[x][y][1]] = true;
                right[map[x][y][2]] = true;
            }
        }

        res = 0;

        batch(1, 0);

        bw.write(res+"");
        bw.flush();

    }

    public static void batch(int L, int count) {
        if (L == 2 * N) {
            if(res<count){
            res = count;
            }
            return;
        }
        if(res>=N*2-L+count){
            return;
        }
        if (!left[L]) {
            batch(L + 1, count);
            return;
        }
        for (Integer R : rights[L]) {
            if (!right[R]) continue;
            right[R] = false;
            batch(L + 1, count + 1);
            right[R] = true;
            if(res>=N*2-L+count){
                return;
            }
        }
        batch(L + 1, count);
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