
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int U = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);

        if((L>=260 || U>=8000) && N>=1000){
            bw.write("Very Good");
        }else if(N>=1000){
            bw.write("Good");
        }else{
            bw.write("Bad");
        }

        bw.flush();

    }
}