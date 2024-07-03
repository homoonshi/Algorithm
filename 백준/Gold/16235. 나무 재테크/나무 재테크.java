import java.io.*;
import java.util.*;

public class Main {

    static class Tree implements Comparable<Tree>{

        int x,y,age;

        Tree(int x,int y,int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age-o.age;
        }
    }

    static int N, M, K;
    static int[][] map;
    static int[][] A;
    static PriorityQueue<Tree> trees;
    static Deque<Tree> deadTree = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new int[N][N];
        A = new int[N][N];

        trees = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(input[j]);
                map[i][j] = 5;
            }
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            int z = Integer.parseInt(input[2]);

            trees.add(new Tree(x,y,z));
        }

        for(int i=0; i<K; i++){
            spring();
            summer();
            autumn();
            winter();
        }

        int res = trees.size();

        bw.write(res+"");
        bw.flush();

    }

    public static void spring(){

        int x,y,age;
        Deque<Tree> liveTree = new ArrayDeque<>();
        int length = trees.size();

        for(int i=0; i<length; i++){

            Tree tree = trees.poll();

            x = tree.x;
            y = tree.y;
            age = tree.age;

            if(map[x][y]>=age){
                map[x][y] -= age;
                tree.age++;
                liveTree.add(tree);
            }else{
                deadTree.addLast(tree);
            }

        }

        while(!liveTree.isEmpty()){

            Tree tree = liveTree.pollFirst();
            trees.add(tree);

        }

    }

    public static void summer(){

        Tree tree;
        int x,y,age;

        while(!deadTree.isEmpty()){

            tree = deadTree.pollFirst();

            map[tree.x][tree.y] += (tree.age/2);

        }

    }

    public static void autumn(){

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};

        int nx, ny;
        int length = trees.size();

        Deque<Tree> tree = new ArrayDeque<>();


        for(int t=0; t<length; t++){

            Tree temp = trees.poll();
            tree.add(temp);

            if(temp.age%5==0){

                for(int i=0; i<8; i++){
                    nx = temp.x + dx[i];
                    ny = temp.y + dy[i];

                    if(!isIn(nx,ny)) continue;

                    tree.add(new Tree(nx,ny,1));
                }

            }

        }

        while(!tree.isEmpty()){

            trees.add(tree.pollFirst());

        }

    }

    public static void winter(){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] += A[i][j];
            }
        }

    }

    public static boolean isIn(int x, int y){
        if(x>=0&&x<N&&y>=0&&y<N){
            return true;
        }
        return false;
    }

}