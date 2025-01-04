
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        char[][] map = new char[N][M];
        int[] startZone = new int[2];

        for(int i=0; i<N; i++){
            String inputStr = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = inputStr.charAt(j);
                if(map[i][j]=='I'){
                    startZone[0] = i;
                    startZone[1] = j;
                }
            }
        }

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        Deque<int[]> deque = new ArrayDeque<>();
        int[][] visited = new int[N][M];

        deque.add(startZone);
        int result = 0;

        visited[startZone[0]][startZone[1]]=1;

        while(!deque.isEmpty()){

            int[] temp = deque.pollFirst();

            for(int i=0; i<4; i++){

                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(!isIn(nx,ny) || visited[nx][ny]==1 || map[nx][ny]=='X'){
                    continue;
                }

                if(map[nx][ny]=='P'){
                    result++;
                }

                deque.addLast(new int[]{nx, ny});
                visited[nx][ny]=1;

            }

        }

        if(result==0){
            bw.write("TT");
        }else{
            bw.write(result+"");
        }
        bw.flush();

    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }

}
