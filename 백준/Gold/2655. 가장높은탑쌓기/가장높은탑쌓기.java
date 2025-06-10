
import java.io.*;
import java.util.*;

public class Main {

    static class Brick implements Comparable<Brick> {

        int index, bottom, height, weight;

        public Brick(int index, int bottom, int height, int weight) {
            this.index = index;
            this.bottom = bottom;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.bottom - this.bottom;
        }
    }

    static int N;
    static int height;
    static Deque<Integer> res;
    static List<Integer> lists;
    static Brick[] brick;
    static int[] remain;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        brick = new Brick[N];
        height = 0;
        lists = new ArrayList<>();
        int sum = 0;

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int bottom = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            Brick b = new Brick(i + 1, bottom, height, weight);
            brick[i] = b;
            sum += height;
        }

        Arrays.sort(brick);

        remain = new int[N];
        remain[0] = sum;

        for(int i=1; i<N; i++){
            sum -= brick[i-1].height;
            remain[i] = sum;
        }

        recursion(0, 0, 10001);

        bw.write(res.size()+"\n");

        while(!res.isEmpty()){
            bw.write(res.pollLast()+"\n");
        }

        bw.flush();

    }

    public static void recursion(int c, int h, int w){

        if(c==N){
            if(height < h){
                res = new ArrayDeque<>();
                int size = lists.size();
                for(int i=0; i<size; i++){
                    res.add(lists.get(i));
                }
                height = h;
            }
            return;
        }

        if(height >= h + remain[c]) return;

        if(brick[c].weight<w) {
            lists.add(brick[c].index);
            recursion(c + 1, h + brick[c].height, brick[c].weight);
            lists.remove(lists.size()-1);
        }

        recursion(c+1, h, w);

    }

}