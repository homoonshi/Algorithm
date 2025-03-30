
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];
        int sX = 0;
        int sY = 0;

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==2){
                    sX = i;
                    sY = j;
                }
            }
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{sX, sY, 0});

        int[][] result = new int[n][m];

        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};

        while(!deque.isEmpty()){

            int[] temp = deque.pollFirst();

            for(int i=0; i<4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(!isIn(nx, ny) || map[nx][ny]==0 || result[nx][ny]!=0){
                    continue;
                }

                result[nx][ny] = temp[2] + 1;
                deque.addLast(new int[]{nx, ny, temp[2]+1});
            }

        }

        result[sX][sY] = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(result[i][j]==0 && map[i][j]==1){
                    bw.write("-1 ");
                    continue;
                }
                bw.write(result[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();

    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<n && y>=0 && y<m){
            return true;
        }
        return false;
    }

}
