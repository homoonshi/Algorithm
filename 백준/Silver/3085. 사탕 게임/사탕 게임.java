
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;
    static Map<Character,Integer> color;

    public static void main(String[] args)  throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        String input;

        for(int i=0; i<N; i++){
            input = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j);
            }
        }

        color = new HashMap<>();

        color.put('C',0);
        color.put('P',1);
        color.put('Z',2);
        color.put('Y',3);

        int result = 0;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int nx, ny;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                for(int k=0; k<4; k++) {

                    nx = i + dx[k];
                    ny = j + dy[k];

                    if(!isIn(nx,ny)){
                        continue;
                    }

                    char current = map[i][j];
                    char next = map[nx][ny];

                    map[i][j] = next;
                    map[nx][ny] = current;

                    result = Math.max(result, widthSearch(i,j));
                    result = Math.max(result, heightSearch(i,j));

                    map[i][j] = current;
                    map[nx][ny] = next;

                }
            }
        }

        bw.write(result+"");
        bw.flush();

    }

    public static int widthSearch(int x, int y){

        int[] dy = {1,-1};

        int ny;

        char current = map[x][y];
        int[] visit = new int[N];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(y);

        int result = 0;

        while(!deque.isEmpty()){

            int cy = deque.poll();

            for(int i=0; i<2; i++){
                ny = cy + dy[i];
                if(!isIn(x,ny)||visit[ny]==1||current!=map[x][ny]){
                    continue;
                }
                result++;
                deque.add(ny);
                visit[ny]=1;
            }

        }

        return result;
    }

    public static int heightSearch(int x, int y){


        int[] dx = {1,-1};

        int nx;

        char current = map[x][y];
        int[] visit = new int[N];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(x);

        int result = 0;

        while(!deque.isEmpty()){

            int cx = deque.poll();

            for(int i=0; i<2; i++){
                nx = cx + dx[i];
                if(!isIn(nx,y)||visit[nx]==1||current!=map[nx][y]){
                    continue;
                }
                result++;
                deque.add(nx);
                visit[nx]=1;
            }

        }

        return result;
    }

    public static boolean isIn(int x,int y){
        if(x>=0&&y>=0&&x<N&&y<N){
            return true;
        }
        return false;
    }

}