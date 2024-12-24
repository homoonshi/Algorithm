
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] result = searchRoute(N);

        bw.write(N+"\n");

        for(int i=0; i<result.length; i++){
            bw.write(result[i]+" ");
        }

        bw.flush();

    }

    public static int[] searchRoute(int n){

        int[] res = new int[n+1];
        int direction = 0;
        int count = 1;

        if(n%3!=2){
            res[0] = 1;
            for(int i=1; i<n; i++){
                if(direction==0){
                    res[i] = res[i-1] + 2;
                    count++;
                    if(count==2){
                        direction=1;
                    }
                }else{
                    res[i] = res[i-1] - 1;
                    count=0;
                    direction=0;
                }
            }
            res[n] = 1;
        }else{
            res[0] = 1;
            res[1] = 2;
            for(int i=2; i<n; i++){
                if(direction==0){
                    res[i] = res[i-1] + 2;
                    count++;
                    if(count==2){
                        direction=1;
                    }
                }else{
                    res[i] = res[i-1] - 1;
                    count=0;
                    direction=0;
                }
            }
            res[n] = 1;
        }

        return res;
    }

}
