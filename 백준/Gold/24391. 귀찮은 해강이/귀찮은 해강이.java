
import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        parent = new int[N+1];

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            union(a, b);
        }

        input = br.readLine().split(" ");

        int result = 0;
        int current = Integer.parseInt(input[0]);
        int route = find(current);

        for(int i=1; i<N; i++){
            current = Integer.parseInt(input[i]);
            int p = find(current);
            if(route != p){
                route = p;
                result++;
            }
        }

        bw.write(result+"");
        bw.flush();

    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA!=parentB){
            parent[parentB] = parentA;
        }

    }

    public static int find(int n){
        if(parent[n]==n){
            return n;
        }
        return parent[n] = find(parent[n]);
    }

}
