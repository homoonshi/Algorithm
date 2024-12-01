import java.io.*;
import java.util.*;

public class Main {

    static class Metal {

        int M, P;

        Metal(int M, int P){
            this.M = M;
            this.P = P;
        }

    }

    static int W, N;
    static List<Metal> metals;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        
        W = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        metals = new ArrayList<>();

        for(int i=0; i<N; i++){

            input = br.readLine().split(" ");

            int M = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);

            metals.add(new Metal(M, P));
            
        }

        metals.sort((o1, o2) -> o2.P-o1.P);

        int result = 0;
        int w = 0;
        int index = 0;

        while(w < W){

            int M = metals.get(index).M;
            int P = metals.get(index).P;

            if(w+M >= W){
                int m = W-w;
                result += P*m;
                w = W;
            }else {
                result += P*M;
                w += M;
                index++;
            }

        }

        bw.write(result+"");
        bw.flush();
        
    }
}