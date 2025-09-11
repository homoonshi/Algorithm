import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        char[][] building = new char[M*5+1][N*5+1];

        for(int i=0; i<=M*5; i++){
            String in = br.readLine();
            for(int j=0; j<=N*5; j++){
                building[i][j] = in.charAt(j);
            }
        }

        int wall = 0;

        int[] res = new int[5];

        for(int i=1; i<M*5; i+=5){
            next : for(int j=1; j<N*5; j+=5){
                int stack = 0;
                for(int k=i; k<=i+4; k++){
                    if(building[k][j]=='*'){
                        stack++;
                    }else{
                        res[stack]++;
                        continue next;
                    }
                }
            }
        }

        for(int i=0; i<5; i++){
            bw.write(res[i]+" ");
        }

        bw.flush();

    }
}