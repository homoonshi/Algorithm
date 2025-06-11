
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] chicken;
    static int[][] distance;
    static List<int[]> store;
    static List<int[]> home;
    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        store = new ArrayList<>();
        home = new ArrayList<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                int m = Integer.parseInt(input[j]);
                if(m==1){
                    home.add(new int[]{i, j});
                }else if(m==2){
                    store.add(new int[]{i, j});
                }
            }
        }

        chicken = new int[M];
        distance = new int[home.size()][store.size()];

        initDistance();
        res = Integer.MAX_VALUE;
        recursion(0, 0);

        bw.write(res+"");
        bw.flush();

    }

    public static void initDistance(){
        for(int i=0; i<home.size(); i++){
            int[] h = home.get(i);
            for(int j=0; j<store.size(); j++){
                int[] s = store.get(j);
                distance[i][j] = Math.abs(h[0]-s[0]) + Math.abs(h[1]-s[1]);
            }
        }
    }

    public static void recursion(int index, int count){

        if(count == M){
            int sum = 0;
            for(int i=0; i<home.size(); i++) {
                int min = distance[i][chicken[0]];
                for (int j = 1; j < M; j++) {
                    min = Math.min(distance[i][chicken[j]], min);
                }
                sum += min;
            }
            res = Math.min(res, sum);
            return;
        }

        if(M-count > store.size()-index){
            return;
        }

        chicken[count] = index;
        recursion(index+1, count+1);
        recursion(index+1 ,count);

    }

}