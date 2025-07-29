import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int L = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        int r = L*P;
        input = br.readLine().split(" ");

        for(int i=0; i<5; i++){

            int n = Integer.parseInt(input[i]);

            bw.write(n-r+" ");

        }

        bw.flush();

    }
}