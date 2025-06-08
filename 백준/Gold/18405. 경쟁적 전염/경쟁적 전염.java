
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] map;
    static List<int[]>[] lists;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        map = new int[N][N];

        lists = new List[K+1];

        for(int i=1; i<=K; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]>0){
                    lists[map[i][j]].add(new int[]{i, j});
                }
            }
        }

        input = br.readLine().split(" ");

        int S = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);
        int Y = Integer.parseInt(input[2]);

        for(int i=0; i<S; i++){
            virus();
        }

        bw.write(map[X-1][Y-1]+"");
        bw.flush();

    }

    public static void virus(){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int i=1; i<=K; i++){
            int size = lists[i].size();
            Deque<Integer> deque = new ArrayDeque<>();
            for(int j=0; j<size; j++){
                int[] temp = lists[i].get(j);
                int c = 0;
                for(int k=0; k<4; k++){
                    int nx = temp[0] + dx[k];
                    int ny = temp[1] + dy[k];
                    if(!isIn(nx, ny) || map[nx][ny]!=0) continue;
                    map[nx][ny] = i;
                    lists[i].add(new int[]{nx, ny});
                    c++;
                }
                if(c==0){
                    deque.add(j);
                }
            }
            size = 0;
            while(!deque.isEmpty()){
                lists[i].remove(deque.poll()-size);
                size++;
            }
        }
    }

    public static boolean isIn(int x,int y){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }
        return false;
    }

}