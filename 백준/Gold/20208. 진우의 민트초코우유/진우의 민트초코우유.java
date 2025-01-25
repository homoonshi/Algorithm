import java.util.*;
import java.io.*;

public class Main {

    static class Milk {
        int x, y, index;

        public Milk(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    static int[][] map;
    static int N, M, H;
    static int[] home;
    static List<Milk> milks;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        map = new int[N][N];
        home = new int[2];
        int currentMilk = 0;
        milks = new ArrayList<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==1){
                    home[0] = i;
                    home[1] = j;
                    continue;
                }
                if(map[i][j]==2){
                    milks.add(new Milk(i, j, currentMilk++));
                }
            }
        }

        int result = searchMilk();

        bw.write(result+"");
        bw.flush();

    }

    static class Move {
        int x, y, h;
        int eatenMask;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
            this.h = M;
            this.eatenMask = 0;
        }

        public Move(int x, int y, int h, int eatenMask) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.eatenMask = eatenMask;
        }

        public boolean hasEaten(int index){
            return (this.eatenMask & (1 << index)) != 0;
        }

        public void eatMilk(int index){
            this.eatenMask |= (1 << index);
        }
    }

    public static int searchMilk(){

        Deque<Move> deque = new ArrayDeque<>();
        deque.add(new Move(home[0], home[1]));

        int result = 0;

        while (!deque.isEmpty()){

            Move temp = deque.pollFirst();

            for (Milk milk : milks) {

                if(temp.hasEaten(milk.index)){
                    continue;
                }

                int hp = Math.abs(temp.x - milk.x) + Math.abs(temp.y - milk.y);

                if(hp <= temp.h){
                    int newMask = temp.eatenMask | (1 << milk.index);
                    int newHp = temp.h - hp + H;

                    Move m = new Move(milk.x, milk.y, newHp, newMask);
                    m.eatMilk(milk.index);
                    deque.add(m);

                    int homeHp = Math.abs(milk.x - home[0]) + Math.abs(milk.y - home[1]);
                    if(homeHp <= newHp){
                        result = Math.max(result, Integer.bitCount(newMask));
                    }
                }

            }

        }

        return result;
    }

}
