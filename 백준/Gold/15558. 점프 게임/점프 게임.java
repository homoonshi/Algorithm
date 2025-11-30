import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] nums = new int[2][N];
        boolean[][] visited = new boolean[2][N];

        String in;

        for(int i=0; i<2; i++){
            in = br.readLine();
            for(int j=0; j<N; j++){
                nums[i][j] = in.charAt(j) - '0';
            }
        }

        Deque<int[]> deque = new ArrayDeque<>(); // x좌표, y좌표, time(y좌표제한)
        deque.add(new int[]{0, 0, 0});
        boolean depart = false;

        int[] dx = {0, 0, -1};
        int[] dy = {1, -1, k};

        loof : while(!deque.isEmpty()){
            int[] temp = deque.pollFirst();
            int time = temp[2] + 1;

            int flag = temp[0] == 0 ? -1 : 1;

            for(int i=0; i<3; i++){
                int x = dx[i];
                if(i==2) x *= flag;

                int nx = temp[0] + x;
                int ny = temp[1] + dy[i];

                if((ny==N-1 && nums[nx][ny]==1) || ny > N-1){
                    depart = true;
                    break loof;
                }

                if(!isIn(nx, ny) || visited[nx][ny] || nums[nx][ny] == 0 || ny < time) continue;

                visited[nx][ny] = true;
                deque.add(new int[]{nx, ny, time});
            }
        }

        bw.write(depart ? "1" : "0");
        bw.flush();

    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<N && y>=0){
            return true;
        }
        return false;
    }

}