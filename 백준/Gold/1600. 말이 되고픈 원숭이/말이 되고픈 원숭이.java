
import java.util.*;
import java.io.*;

public class Main {

  static int K;
  static int W,H;
  static int[][] map;

  static int[] dx = {0,1,0,-1};
  static int[] dy = {1,0,-1,0};

  static int[] hx = {-2,-1,-2,-1,1,2,1,2};
  static int[] hy = {-1,-2,1,2,2,1,-2,-1};

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] inputs;

    K = Integer.parseInt(br.readLine());
    inputs = br.readLine().split(" ");

    W = Integer.parseInt(inputs[0]);
    H = Integer.parseInt(inputs[1]);

    map = new int[H][W];

    for(int i=0; i<H; i++){
      inputs = br.readLine().split(" ");
      for(int j=0; j<W; j++){
        map[i][j] = Integer.parseInt(inputs[j]);
      }
    }

    bw.write(BFS()+"");
    bw.flush();

  }

  public static int BFS(){

    if((H-1)==0&&(W-1)==0){
      return 0;
    }

    Deque<int[]> deque = new ArrayDeque<>();
    deque.addLast(new int[]{0,0,K,0});

    int[][][] visit = new int[K+1][H][W];
    visit[K][0][0]=1;

    int[] temp;

    int nx, ny, k, t;

    while(!deque.isEmpty()){

      temp = deque.pollFirst();

      k = temp[2];
      t = temp[3];

      for(int i=0; i<4; i++){

        nx = temp[0] + dx[i];
        ny = temp[1] + dy[i];

        if(!isIn(nx, ny)||visit[k][nx][ny]==1||map[nx][ny]==1){
          continue;
        }

        if(nx==H-1&&ny==W-1){
          return t+1;
        }

        deque.addLast(new int[]{nx,ny,k,t+1});
        visit[k][nx][ny]=1;

      }

      if(k!=0){

        for(int i=0; i<8; i++){

          nx = temp[0] + hx[i];
          ny = temp[1] + hy[i];

          if(!isIn(nx, ny)||visit[k-1][nx][ny]==1||map[nx][ny]==1){
            continue;
          }

          if(nx==H-1&&ny==W-1){
            return t+1;
          }

          deque.addLast(new int[]{nx,ny,k-1,t+1});
          visit[k-1][nx][ny]=1;

        }

      }

    }

    return -1;
  }

  public static boolean isIn(int x,int y){
    if(x>=0&&x<H&&y>=0&&y<W){
      return true;
    }
    return false;
  }

}