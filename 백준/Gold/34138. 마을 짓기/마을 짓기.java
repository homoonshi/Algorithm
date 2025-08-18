import java.io.*;
import java.util.*;

public class Main {

    static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] map;
    static boolean[][] dp;
    static Position[][] positions;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        map = new boolean[N][M];
        dp = new boolean[N][M];
        positions = new Position[N][M];
        List<Position>[] lists = new List[N];
        int k = Math.min(N, M);
        int zero = 0;

        int[] ch = new int[N];
        List<Integer> h = new ArrayList<>();

        for(int i=0; i<N; i++){
            String in = br.readLine();
            lists[i] = new ArrayList<>();
            for(int j=0; j<M; j++){
                if(in.charAt(j)=='X'){
                    map[i][j] = true;
                    dp[i][j] = true;
                    zero++;
                    positions[i][j] = new Position(i, j);
                    lists[i].add(positions[i][j]);
                    ch[i]++;
                }
            }
        }

        for(int i=0; i<N; i++){
            if(ch[i]>0){
                h.add(i);
            }
        }

        int[] res = new int[k+1];
        res[1] = zero;

        for(int i=2; i<=k; i++){
            List<Integer> rmvh = new ArrayList<>();
            for (Integer n : h) {
                if(n>=N-i+1) break;
                int c = 0;
                List<Position> rmv = new ArrayList<>();
                for (Position position : lists[n]) {
                    if(position.y>=M-i+1){
                        if(c==0){
                            rmvh.add(n);
                        }
                        break;
                    }
                    if(!dp[n][position.y]){
                        continue;
                    }
                    if(!check(position.x, position.y, i)){
                        dp[position.x][position.y] = false;
                        rmv.add(positions[position.x][position.y]);
                        continue;
                    }
                    res[i]++;
                    c++;
                }
                for (Position position : rmv) {
                    lists[n].remove(position);
                }
            }
            for (Integer integer : rmvh) {
                h.remove(integer);
            }
        }

        for(int i=1; i<=k; i++){
            bw.write(res[i]+"\n");
        }

        bw.flush();

    }

    public static boolean check(int x, int y, int size){
        if(!dp[x+1][y+1]){
            return false;
        }
        if(map[x+size-1][y] || map[x][y+size-1]){
            return false;
        }
        return true;
    }

}