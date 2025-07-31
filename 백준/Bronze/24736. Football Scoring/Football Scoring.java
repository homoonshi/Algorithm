import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] res = new int[2];
        int[] num = new int[5];

        num[0] = 6;
        num[1] = 3;
        num[2] = 2;
        num[3] = 1;
        num[4] = 2;

        for(int i=0; i<2; i++){
            String[] input = br.readLine().split(" ");

            for(int j=0; j<5; j++){
                res[i] += Integer.parseInt(input[j]) * num[j];
            }
        }

        bw.write(res[0]+" "+res[1]);
        bw.flush();

    }
}