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

        int max = 0;

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int res = 1;

        for(int i=1; i<max; i++){
            res = Math.max(res, search(i));
        }

        bw.write(res+"");
        bw.flush();
    }

    public static int search(int h){
        boolean[][] visit = new boolean[N][N];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visit[i][j] || map[i][j]<=h){
                    continue;
                }
                visit[i][j] = true;
                Deque<int[]> deque = new ArrayDeque<>();
                deque.add(new int[]{i, j});
                count++;
                while(!deque.isEmpty()){
                    int[] temp = deque.pollFirst();
                    for(int k=0; k<4; k++){
                        int nx = temp[0] + dx[k];
                        int ny = temp[1] + dy[k];
                        if(!isIn(nx, ny) || map[nx][ny]<=h || visit[nx][ny]){
                            continue;
                        }
                        deque.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        return count;
    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }
        return false;
    }

}