import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        int standard = N;

        for(int i=0; i<N-2; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            group(a, b);
            standard = Math.min(standard, Math.min(a, b));
        }

        int res = 0;

        for(int i=1; i<=N; i++){
            if(parent[i] == i && i != standard){
                res = i;
            }
        }

        bw.write(standard+" "+res);
        bw.flush();

    }

    public static void group(int a, int b){

        int parentA = searchParent(a);
        int parentB = searchParent(b);

        if(parentA <= parentB){
            parent[parentB] = parentA;
            searchParent(b);
        }else{
            parent[parentA] = parentB;
            searchParent(a);
        }

    }

    public static int searchParent(int index){
        if(index==parent[index]){
            return index;
        }
        return parent[index] = searchParent(parent[index]);
    }

}