
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, P, HP;
    static boolean[][] wall;
    static Deque<int[]>[] p;
    static List<Integer> ps;
    static int[] boss;
    static Map<Character, Integer> player;
    static boolean[][][] isVisit;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        P = Integer.parseInt(input[2]);

        p = new Deque[26];
        ps = new ArrayList<>();
        wall = new boolean[M][N];
        isVisit = new boolean[26][M][N];

        for(int i=0; i<26; i++){
            p[i] = new ArrayDeque<>();
        }

        boss = new int[2];
        player = new HashMap<>();

        for(int i=0; i<M; i++){
            String in = br.readLine();
            for(int j=0; j<N; j++){
                char c = in.charAt(j);
                if(c!='.' && c!='X'){
                    if(c=='B'){
                        boss[0] = i;
                        boss[1] = j;
                        continue;
                    }
                    p[c-97].addLast(new int[]{i, j});
                    ps.add(c-97);
                    continue;
                }
                if(c=='X'){
                    wall[i][j] = true;
                }
            }
        }

        for(int i=0; i<P; i++){
            input = br.readLine().split(" ");
            player.put(input[0].charAt(0), Integer.parseInt(input[1]));
        }

        HP = Integer.parseInt(br.readLine());

        bw.write(round()+"");
        bw.flush();

    }

    public static int round(){

        List<Character> attackPlayer = new ArrayList<>();
        int size = 0;

        while (HP>0){
            size = attackPlayer.size();

            for(int i=0; i<size; i++){
                HP -= player.get(attackPlayer.get(i));
            }

            if(size != P){
                attackPlayer = move(attackPlayer);
            }
        }

        return size;
    }

    public static List<Character> move(List<Character> attack){

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int size = ps.size();
        List<Integer> remove = new ArrayList<>();

        loof : for(int i=0; i<size; i++){

            int index = ps.get(i);
            int s = p[index].size();

            for(int j=0; j<s; j++){

                int[] temp = p[index].pollFirst();

                if(temp == null){
                    continue;
                }

                int x = temp[0];
                int y = temp[1];

                for(int k=0; k<4; k++){

                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if(!isIn(nx, ny) || wall[nx][ny] || isVisit[index][nx][ny]){
                        continue;
                    }

                    if(boss[0]==nx && boss[1]==ny){
                        p[index].clear();
                        remove.add(i);
                        attack.add((char)(index+97));
                        continue loof;
                    }

                    p[index].addLast(new int[]{nx, ny});
                    isVisit[index][nx][ny] = true;

                }
            }
        }

        int s = remove.size();

        for(int i=0; i<s; i++){
            ps.remove(remove.get(i)-i);
        }

        return attack;
    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<M && y>=0 && y<N){
            return true;
        }
        return false;
    }

}