import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] town = new int[n];
        int distance = 1000000;

        for(int i=0; i<n; i++){
            town[i] = Integer.parseInt(input[i]);
            if(i>0){
                distance = Math.min(distance, town[i]-town[i-1]);
            }
        }

        int result = 0;
        
        for(int i=1; i<n; i++){
            if((town[i]-town[i-1]) == distance){
                result++;
            }
        }

        bw.write(result+"");
        bw.flush();
        
    }
}