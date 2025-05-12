
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] level = new int[N];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            level[i] = Integer.parseInt(input[i]);

            if(level[i]==300){
                bw.write("1 ");
            }else if(level[i]>=275){
                bw.write("2 ");
            }else if(level[i]>=250){
                bw.write("3 ");
            }else{
                bw.write("4 ");
            }
        }

        bw.flush();

    }
}