
import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                if(input.charAt(j)=='X'){
                    map[i][j] = 1;
                }
            }
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        int w = 0;
        int h = 0;

        boolean[][][] visit = new boolean[2][n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1 || (visit[0][i][j]&&visit[1][i][j])){
                    continue;
                }
                for(int k=0; k<2; k++){

                    int nx = i;
                    int ny = j;
                    int count = 0;

                    if(visit[k][nx][ny]){
                        continue;
                    }

                    visit[k][nx][ny] = true;

                    while(true){
                        nx += dx[k];
                        ny += dy[k];
                        if(!isIn(nx, ny) || map[nx][ny]==1){
                            break;
                        }
                        visit[k][nx][ny] = true;
                        count++;
                    }

                    if(count==0){
                        continue;
                    }

                    if(k==0){
                        w++;
                    }else{
                        h++;
                    }
                }
            }
        }

        bw.write(w+" "+h);
        bw.flush();

    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<n && y>=0 && y<n){
            return true;
        }
        return false;
    }

}
