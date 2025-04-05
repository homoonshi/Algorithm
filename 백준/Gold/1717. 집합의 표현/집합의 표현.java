
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] parent;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if(command==0){
                union(a, b);
            }else{
                if(find(a)==find(b)){
                    bw.write("YES\n");
                }else{
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();

    }

    public static int find(int a){
        if(a==parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){

        int parentA = find(a);
        int parentB = find(b);

        if(parentA<parentB){
            parent[parentB] = parentA;
        }else{
            parent[parentA] = parentB;
        }

    }

}
